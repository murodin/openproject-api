package tug.it.openprojectapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material_budget_items",
        catalog = "openproject"
)
public class MaterialBudgetItems {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "cost_object_id", unique = true, nullable = false)
    private Integer costObjectId;

    @Column(name = "units", unique = true, nullable = false)
    private Double units;

    @Column(name = "cost_type_id", unique = true, nullable = false)
    private Integer costTypeId;
}
