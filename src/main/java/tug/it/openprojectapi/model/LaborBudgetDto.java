package tug.it.openprojectapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "LaborBudgetDto", description = "LaborBudget Data Transfer Objects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaborBudgetDto {

    @ApiModelProperty(notes = "id", example = "1453", position = 0)
    private Integer id;
    @ApiModelProperty(notes = "user_id", example = "1", position = 1)
    private Integer user_id;
    @ApiModelProperty(notes = "hours", example = "10.0", position = 2)
    private Double hours;
    @ApiModelProperty(notes = "budget", example = "1200.0", position = 3)
    private Double budget;
}
