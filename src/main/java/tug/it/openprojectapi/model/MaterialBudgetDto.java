package tug.it.openprojectapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialBudgetDto {
    private Integer id;
    private Integer cost_type_id;
    private Double units;
    private Double budget;
}
