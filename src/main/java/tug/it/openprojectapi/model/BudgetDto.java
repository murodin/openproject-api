package tug.it.openprojectapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BudgetDto {
    private Integer cost_object_id;
    private List<LaborBudgetDto> labor_budgets;
    private List<MaterialBudgetDto> material_budgets;
}
