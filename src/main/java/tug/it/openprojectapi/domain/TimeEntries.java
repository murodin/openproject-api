package tug.it.openprojectapi.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "time_entries",
        catalog = "openproject"
)
public class TimeEntries extends BaseEntries {

    @Builder
    public TimeEntries(Integer id, Integer projectId, Integer userId, Integer workPackageId,
                       Integer rateId, Integer costs,  Integer overridden_costs, Date spentOn,
                       Date createdOn, Date updatedOn, Double hours) {
        super(id, projectId, userId, workPackageId, rateId, costs, overridden_costs, spentOn, createdOn, updatedOn);
        this.hours = hours;
    }

    @Column(name = "hours", unique = true, nullable = false)
    private Double hours;
}
