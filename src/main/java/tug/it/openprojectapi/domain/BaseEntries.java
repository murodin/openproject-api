package tug.it.openprojectapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntries {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "project_id", unique = true, nullable = false)
    private Integer projectId;

    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "work_package_id", unique = true, nullable = false)
    private Integer workPackageId;

    @Column(name = "rate_id", unique = true, nullable = false)
    private Integer rateId;

    @Column(name = "costs", unique = true, nullable = false)
    private Integer costs;

    @Column(name = "overridden_costs", unique = true, nullable = false)
    private Integer overridden_costs;

    @Column(name = "spent_on", unique = true, nullable = false)
    private Date spentOn;

    @Column(name = "created_on", unique = true, nullable = false)
    private Date createdOn;

    @Column(name = "updated_on", unique = true, nullable = false)
    private Date updatedOn;
}
