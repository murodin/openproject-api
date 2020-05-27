package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.CostEntries;

import java.util.List;

public interface CostEntriesRepository extends JpaRepository<CostEntries, Integer> {
    List<CostEntries> findAllByWorkPackageId(Integer workPackageId);
}
