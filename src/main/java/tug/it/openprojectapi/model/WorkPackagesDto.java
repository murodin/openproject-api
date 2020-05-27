package tug.it.openprojectapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkPackagesDto {
    private Integer id;
    private Integer type_id;
    private Integer status_id;
    private Integer assigned_to_id;
    private Integer author_id;
    private Integer cost_object_id;
    private Integer labor_costs;
    private Integer material_costs;
    private Integer done_ratio;
    private Double estimated_hours;
    private Double remaining_hours;
    private String subject;
    private Date start_date;
    private Date created_at;
}
