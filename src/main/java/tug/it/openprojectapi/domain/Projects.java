package tug.it.openprojectapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects",
        catalog = "openproject"
)
public class Projects {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "parent_id", unique = true, nullable = false)
    private Integer parentId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "identifier", unique = true, nullable = false)
    private String identifier;

    @Column(name = "active", unique = true, nullable = false)
    private boolean active;

    @Column(name = "created_at", unique = true, nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", unique = true, nullable = false)
    private Timestamp updatedAt;
}
