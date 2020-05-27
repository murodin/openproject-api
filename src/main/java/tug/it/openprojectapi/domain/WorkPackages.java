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
    private Integer projectId;

    @Column(name = "type_id", unique = true, nullable = false)
    private Integer typeId;

    @Column(name = "status_id", unique = true, nullable = false)
    private Integer statusId;

    @Column(name = "assigned_to_id", unique = true, nullable = false)
    private Integer assignedToId;

    @Column(name = "author_id", unique = true, nullable = false)
    private Integer authorId;

    @Column(name = "cost_object_id", unique = true, nullable = false)
    private Integer costObjectId;

    @Column(name = "done_ratio", unique = true, nullable = false)
    private Integer doneRatio;

    @Column(name = "estimated_hours", unique = true, nullable = false)
    private Double estimatedHours;

    @Column(name = "remaining_hours", unique = true, nullable = false)
    private Double remainingHours;

    @Column(name = "subject", unique = true, nullable = false)
    private String subject;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "start_date", unique = true, nullable = false)
    private Date startDate;

    @Column(name = "due_date", unique = true, nullable = false)
    private Date dueDate;

    @Column(name = "created_at", unique = true, nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", unique = true, nullable = false)
    private Date updatedAt;
}
