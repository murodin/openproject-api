package tug.it.openprojectapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "MaterialBudgetDto", description = "MaterialBudget Data Transfer Objects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialBudgetDto {

    @ApiModelProperty(notes = "id", example = "1453", position = 0)
    private Integer id;
    @ApiModelProperty(notes = "cost_type", example = "1", position = 1)
    private String cost_type;
    @ApiModelProperty(notes = "units", example = "12.0", position = 2)
    private Double units;
    @ApiModelProperty(notes = "budget", example = "1200.0", position = 3)
    private Double budget;
}
