package tug.it.openprojectapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaborBudgetDto {
    private Integer id;
    private Integer user_id;
    private Double hours;
    private Double budget;
}
