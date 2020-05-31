package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tug.it.openprojectapi.domain.BaseEntries;
import tug.it.openprojectapi.domain.WorkPackages;
import tug.it.openprojectapi.exception.RatesNotFoundException;
import tug.it.openprojectapi.exception.WorkPackagesNotFoundException;
import tug.it.openprojectapi.model.WorkPackagesDto;
import tug.it.openprojectapi.respository.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class WorkPackagesService {

    private final WorkPackagesRepository workPackagesRepository;
    private final CostEntriesRepository costEntriesRepository;
    private final TimeEntriesRepository timeEntriesRepository;
    private final UsersService usersService;

    @Autowired
    private RatesRepository ratesRepository;

    Predicate<Integer> isRateCostRate = rateId -> ratesRepository.findById(rateId)
            .orElseThrow(() -> new RatesNotFoundException(String.format("Rates Not Found for Id: %s", rateId)))
            .getType().equals("CostRate");

    Predicate<Integer> isRateHourlyRate = rateId -> ratesRepository.findById(rateId)
            .orElseThrow(() -> new RatesNotFoundException(String.format("Rates Not Found for Id: %s", rateId)))
            .getType().equals("HourlyRate");

    Function<List<BaseEntries>, Integer> getOverriddenCostFromEntries = baseEntries ->
            baseEntries.stream()
                .filter(baseEntry -> baseEntry.getOverridden_costs() !=  null)
                .collect(summingInt(BaseEntries::getOverridden_costs));

    BiFunction<List<BaseEntries>, Predicate<Integer>, Integer> getCostFromEntries = (baseEntries, predicate) ->
            baseEntries.stream()
                        .filter(baseEntry -> baseEntry.getOverridden_costs() ==  null &&
                                baseEntry.getRateId() != null &&
                                predicate.test(baseEntry.getRateId()))
                        .collect(summingInt(BaseEntries::getCosts));

    /**
     * Get All WorkPackages
     * @param projectId - Project Id
     * @return List of WorkPackagesDto related with projectId
     */
    public List<WorkPackagesDto> getAllByProjectId(Integer projectId) {
        List<WorkPackages> workPackagesList = Optional
                .ofNullable( workPackagesRepository.findAllByProjectId(projectId))
                .orElseThrow(() -> new WorkPackagesNotFoundException(String.format("WorkPackages Not Found for Project Id: %s", projectId)));

        return workPackagesList.stream()
                .map(this::buildDto)
                .sorted(Comparator.comparing(WorkPackagesDto::getStart_date))
                .collect(toList());
    }

    private WorkPackagesDto buildDto(WorkPackages workPackages) {
        return WorkPackagesDto.builder()
                .id(workPackages.getId())
                .status_id(workPackages.getStatusId())
                .type_id(workPackages.getTypeId())
                .subject(workPackages.getSubject())
                .assigned_user(usersService.getUserFirstLastName(workPackages.getAssignedToId()))
                .author_user(usersService.getUserFirstLastName(workPackages.getAuthorId()))
                .cost_object_id(workPackages.getCostObjectId())
                .material_costs(getCost("Material", workPackages.getId()))
                .labor_costs(getCost("Labor", workPackages.getId()))
                .done_ratio(workPackages.getDoneRatio())
                .estimated_hours(workPackages.getEstimatedHours())
                .remaining_hours(workPackages.getRemainingHours())
                .start_date(workPackages.getStartDate())
                .created_at(workPackages.getCreatedAt())
                .build();
    }

    private Integer getCost(String costType, Integer workPackageId) {
        Optional<List> optionalCostEntries = costType.equalsIgnoreCase("Material") ?
                Optional.ofNullable(costEntriesRepository.findAllByWorkPackageId(workPackageId)) :
                Optional.ofNullable(timeEntriesRepository.findAllByWorkPackageId(workPackageId));

        Predicate<Integer> predicate = costType.equalsIgnoreCase("Material") ? isRateCostRate: isRateHourlyRate;

        return optionalCostEntries.isPresent() ?
                    getCostFromEntries.apply(optionalCostEntries.get(), predicate) +
                    getOverriddenCostFromEntries.apply(optionalCostEntries.get())
                    : 0;
    }
}
