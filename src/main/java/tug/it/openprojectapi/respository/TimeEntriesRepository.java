package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.TimeEntries;

import java.util.List;

public interface TimeEntriesRepository extends JpaRepository<TimeEntries, Integer> {
    List<TimeEntries> findAllByWorkPackageId(Integer workPackageId);
}
