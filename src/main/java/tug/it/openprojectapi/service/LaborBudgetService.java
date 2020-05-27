package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tug.it.openprojectapi.domain.LaborBudgetItems;
import tug.it.openprojectapi.exception.LaborBudgetItemsNotFoundException;
import tug.it.openprojectapi.model.LaborBudgetDto;
import tug.it.openprojectapi.respository.LaborBudgetItemsRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class LaborBudgetService {

    private final LaborBudgetItemsRepository laborBudgetItemsRepository;

    public List<LaborBudgetDto> getAllByCostObjectId(Integer costObjectId) {

        List<LaborBudgetItems> laborBudgetItemsList = Optional.ofNullable(
                laborBudgetItemsRepository.findAllByCostObjectId(costObjectId))
                .orElseThrow(() -> new LaborBudgetItemsNotFoundException(String.format("LaborBudgetItem Not Found for Cost Object Id: %s", costObjectId)));

        return laborBudgetItemsList.stream()
                .map(this::buildDto)
                .collect(toList());

    }

    private LaborBudgetDto buildDto(LaborBudgetItems laborBudgetItems) {
        return LaborBudgetDto.builder()
                .id(laborBudgetItems.getId())
                .hours(laborBudgetItems.getHours())
                .user_id(laborBudgetItems.getUserId())
                .budget(laborBudgetItems.getBudget())
                .build();
    }
}
