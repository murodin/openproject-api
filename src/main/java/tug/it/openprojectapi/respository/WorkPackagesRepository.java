package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.WorkPackages;

import java.util.List;

public interface WorkPackagesRepository extends JpaRepository<WorkPackages, Integer> {
    List<WorkPackages> findAllByProjectId(Integer projectId);
}
