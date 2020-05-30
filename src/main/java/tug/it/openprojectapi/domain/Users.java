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
@Table(name = "users",
        catalog = "openproject"
)
public class Users {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "firstname", unique = true, nullable = false)
    private String firstname;

    @Column(name = "lastname", unique = true, nullable = false)
    private String lastname;

    @Column(name = "admin", unique = true, nullable = false)
    private boolean admin;
}
