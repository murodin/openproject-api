package tug.it.openprojectapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cost_entries",
        catalog = "openproject"
)
public class CostEntries {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "project_id", unique = true, nullable = false)
    private Integer project_id;

    @Column(name = "user_id", unique = true, nullable = false)
    private Integer user_id;

    @Column(name = "work_package_id", unique = true, nullable = false)
    private Integer work_package_id;

    @Column(name = "cost_type_id", unique = true, nullable = false)
    private Integer cost_type_id;

    @Column(name = "rate_id", unique = true, nullable = false)
    private Integer rate_id;

    @Column(name = "units", unique = true, nullable = false)
    private Double units;

    @Column(name = "costs", unique = true, nullable = false)
    private Integer costs;

    @Column(name = "spent_on", unique = true, nullable = false)
    private Date spent_on;

    @Column(name = "created_on", unique = true, nullable = false)
    private Date created_on;

    @Column(name = "updated_on", unique = true, nullable = false)
    private Date updated_on;
}
