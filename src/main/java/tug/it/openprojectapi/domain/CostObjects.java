package tug.it.openprojectapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cost_objects",
        catalog = "openproject"
)
public class CostObjects {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "project_id", unique = true, nullable = false)
    private Integer projectId;

    @Column(name = "author_id", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "subject", unique = true, nullable = false)
    private String subject;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "fixed_date", unique = true, nullable = false)
    private Date fixedDate;

    @Column(name = "created_on", unique = true, nullable = false)
    private Date createdOn;

    @Column(name = "updated_on", unique = true, nullable = false)
    private Date updatedOn;

    public static CostObjects getDefaultCostObjects() {
        return new CostObjects(0, 0, 0, "undefined", "undefined",
                Date.valueOf(LocalDate.now()) , Date.valueOf(LocalDate.now()) , Date.valueOf(LocalDate.now()));
    }
}
