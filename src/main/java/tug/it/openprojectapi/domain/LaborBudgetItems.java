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
@Table(name = "labor_budget_items",
        catalog = "openproject"
)
public class LaborBudgetItems {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "cost_object_id", unique = true, nullable = false)
    private Integer costObjectId;

    @Column(name = "hours", unique = true, nullable = false)
    private Double hours;

    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "budget", unique = true, nullable = false)
    private Double budget;
}
