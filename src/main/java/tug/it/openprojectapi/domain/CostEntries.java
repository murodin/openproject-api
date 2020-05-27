package tug.it.openprojectapi.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cost_entries",
        catalog = "openproject"
)
public class CostEntries extends BaseEntries{

    @Builder
    public CostEntries(Integer id, Integer projectId, Integer userId, Integer workPackageId,
                       Integer rateId, Integer costs,  Integer overridden_costs, Date spentOn,
                       Date createdOn, Date updatedOn, Integer costTypeId, Double units) {
        super(id, projectId, userId, workPackageId, rateId, costs, overridden_costs, spentOn, createdOn, updatedOn);
        this.costTypeId = costTypeId;
        this.units = units;
    }

    @Column(name = "cost_type_id", unique = true, nullable = false)
    private Integer costTypeId;

    @Column(name = "units", unique = true, nullable = false)
    private Double units;
}
