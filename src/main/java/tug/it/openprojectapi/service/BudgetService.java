package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tug.it.openprojectapi.domain.CostObjects;
import tug.it.openprojectapi.exception.CostObjectsNotFoundException;
import tug.it.openprojectapi.model.BudgetDto;
import tug.it.openprojectapi.respository.CostObjectsRepository;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final LaborBudgetService laborBudgetService;
    private final MaterialBudgetService materialBudgetService;

    @Autowired
    private CostObjectsRepository costObjectsRepository;

    Function<Integer, CostObjects> getCostObjectByProjectId = projectId -> costObjectsRepository.findByProjectId(projectId)
            .orElseThrow(() -> new CostObjectsNotFoundException(String.format("Cost Object Not Found for Project Id: %s", projectId)));

    public BudgetDto getByProjectId(Integer projectId) {
        Integer costObjectId = getCostObjectByProjectId.apply(projectId).getId();

        return BudgetDto.builder()
                .cost_object_id(costObjectId)
                .labor_budgets(laborBudgetService.getAllByCostObjectId(costObjectId))
                .material_budgets(materialBudgetService.getAllByCostObjectId(costObjectId))
                .build();
    }
}
