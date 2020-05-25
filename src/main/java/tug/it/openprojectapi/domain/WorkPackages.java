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
@Table(name = "work_packages",
        catalog = "openproject"
)
public class WorkPackages {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "project_id", unique = true, nullable = false)
    private Integer project_id;

    @Column(name = "type_id", unique = true, nullable = false)
    private Integer type_id;

    @Column(name = "status_id", unique = true, nullable = false)
    private Integer status_id;

    @Column(name = "assigned_to_id", unique = true, nullable = false)
    private Integer assigned_to_id;

    @Column(name = "author_id", unique = true, nullable = false)
    private Integer author_id;

    @Column(name = "cost_object_id", unique = true, nullable = false)
    private Integer cost_object_id;

    @Column(name = "done_ratio", unique = true, nullable = false)
    private Integer done_ratio;

    @Column(name = "estimated_hours", unique = true, nullable = false)
    private Double estimated_hours;

    @Column(name = "remaining_hours", unique = true, nullable = false)
    private Double remaining_hours;

    @Column(name = "subject", unique = true, nullable = false)
    private String subject;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "start_date", unique = true, nullable = false)
    private Date start_date;

    @Column(name = "due_date", unique = true, nullable = false)
    private Date due_date;

    @Column(name = "created_at", unique = true, nullable = false)
    private Date created_at;

    @Column(name = "updated_at", unique = true, nullable = false)
    private Date updated_at;
}
