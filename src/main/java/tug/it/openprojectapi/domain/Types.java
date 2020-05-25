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
@Table(name = "types",
        catalog = "openproject"
)
public class Types {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;;

    @Column(name = "is_in_roadmap", unique = true, nullable = false)
    private boolean is_in_roadmap;

    @Column(name = "created_at", unique = true, nullable = false)
    private Date created_at;

    @Column(name = "updated_at", unique = true, nullable = false)
    private Date updated_at;
}