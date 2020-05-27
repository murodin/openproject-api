package tug.it.openprojectapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(value = "BudgetDto", description = "Budget Data Transfer Objects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BudgetDto {

    @ApiModelProperty(notes = "cost_object_id", example = "1453", position = 0)
    private Integer cost_object_id;
    @ApiModelProperty(notes = "labor_budgets", position = 1)
    private List<LaborBudgetDto> labor_budgets;
    @ApiModelProperty(notes = "material_budgets", position = 2)
    private List<MaterialBudgetDto> material_budgets;
}
