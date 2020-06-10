package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tug.it.openprojectapi.domain.MaterialBudgetItems;
import tug.it.openprojectapi.domain.Rates;
import tug.it.openprojectapi.exception.MaterialBudgetItemsNotFoundException;
import tug.it.openprojectapi.exception.RatesNotFoundException;
import tug.it.openprojectapi.model.MaterialBudgetDto;
import tug.it.openprojectapi.respository.CostTypesRepository;
import tug.it.openprojectapi.respository.MaterialBudgetItemsRepository;
import tug.it.openprojectapi.respository.RatesRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaterialBudgetService {

    private final MaterialBudgetItemsRepository materialBudgetItemsRepository;
    private final CostTypesService costTypesService;

    @Autowired
    private  RatesRepository ratesRepository;

    Function<Integer, Rates> getRateByCostTypeId = costTypeId -> Optional.ofNullable(ratesRepository.findAllByCostTypeId(costTypeId))
            .orElseGet(() -> Rates.getDefaultRates());

    public List<MaterialBudgetDto> getAllByCostObjectId(Integer costObjectId) {

        List<MaterialBudgetItems> materialBudgetItemsList = Optional.ofNullable(
                materialBudgetItemsRepository.findAllByCostObjectId(costObjectId))
                .orElseThrow(() -> new MaterialBudgetItemsNotFoundException(String.format("MaterialBudgetItem Not Found for Cost Object Id: %s", costObjectId)));

        return materialBudgetItemsList.stream()
                .map(this::buildDto)
                .collect(toList());
    }

    private MaterialBudgetDto buildDto(MaterialBudgetItems materialBudgetItems){
        return MaterialBudgetDto.builder()
                .id(materialBudgetItems.getId())
                .cost_type(costTypesService.getCostTypesName(materialBudgetItems.getCostTypeId()))
                .units(materialBudgetItems.getUnits())
                .budget(getRateByCostTypeId.apply(materialBudgetItems.getCostTypeId()).getRate() * materialBudgetItems.getUnits())
                .build();
    }
}
