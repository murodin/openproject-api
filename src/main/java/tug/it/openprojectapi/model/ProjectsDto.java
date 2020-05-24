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
public class ProjectsDto {

    private Integer id;
    private Integer parent_id;

    private String name;
    private String description;
    private String identifier;
    private BudgetDto budget;
    private boolean active;

    private Date created_at;
    private Date updated_at;
}
