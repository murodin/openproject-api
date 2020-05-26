package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.CostTypes;

public interface CostTypesRepository extends JpaRepository<CostTypes, Integer> {
}
