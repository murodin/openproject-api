package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.CostObjects;

import java.util.Optional;

public interface CostObjectsRepository extends JpaRepository<CostObjects, Integer> {
    Optional<CostObjects> findByProjectId(Integer projectId);
}
