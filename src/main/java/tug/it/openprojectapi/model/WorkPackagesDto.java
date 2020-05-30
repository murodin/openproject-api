package tug.it.openprojectapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@ApiModel(value = "WorkPackagesDto", description = "WorkPackages Data Transfer Objects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkPackagesDto {
    @ApiModelProperty(notes = "id", example = "1453", position = 0)
    private Integer id;
    @ApiModelProperty(notes = "type_id", example = "1", position = 1)
    private Integer type_id;
    @ApiModelProperty(notes = "status_id", example = "2", position = 2)
    private Integer status_id;
    @ApiModelProperty(notes = "assigned_user", example = "Şinasi Aşağıbakmaz", position = 3)
    private String assigned_user;
    @ApiModelProperty(notes = "author_user", example = "Basri Yukarıçıkmaz", position = 4)
    private String author_user;
    @ApiModelProperty(notes = "cost_object_id", example = "2", position = 5)
    private Integer cost_object_id;
    @ApiModelProperty(notes = "labor_costs", example = "1100", position = 6)
    private Integer labor_costs;
    @ApiModelProperty(notes = "material_costs", example = "1200", position = 7)
    private Integer material_costs;
    @ApiModelProperty(notes = "done_ratio", example = "65", position = 8)
    private Integer done_ratio;
    @ApiModelProperty(notes = "estimated_hours", example = "176.0", position = 9)
    private Double estimated_hours;
    @ApiModelProperty(notes = "remaining_hours", example = "140.0", position = 10)
    private Double remaining_hours;
    @ApiModelProperty(notes = "subject", example = "Test Milestone", position = 11)
    private String subject;
    @ApiModelProperty(notes = "start_date", example = "2020-01-01", position = 12)
    private Date start_date;
    @ApiModelProperty(notes = "created_at", example = "2020-01-01", position = 13)
    private Date created_at;
}
