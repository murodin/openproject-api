package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.CostEntries;

public interface CostEntriesRepository extends JpaRepository<CostEntries, Integer> {
}
