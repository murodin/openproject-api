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
@Table(name = "rates",
        catalog = "openproject"
)
public class Rates {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "cost_type_id", unique = true, nullable = false)
    private Integer cost_type_id;

    @Column(name = "project_id", unique = true, nullable = false)
    private Integer project_id;

    @Column(name = "user_id", unique = true, nullable = false)
    private Integer user_id;

    // Type: CostRate/HourlyRate/...
    @Column(name = "type", unique = true, nullable = false)
    private String type;

    @Column(name = "rate", unique = true, nullable = false)
    private Double rate;

    @Column(name = "valid_from", unique = true, nullable = false)
    private Date valid_from;
}
