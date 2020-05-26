package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.WorkPackages;

public interface WorkPackagesRepository extends JpaRepository<WorkPackages, Integer> {
}
