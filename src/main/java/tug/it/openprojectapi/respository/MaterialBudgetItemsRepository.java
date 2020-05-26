package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.MaterialBudgetItems;

public interface MaterialBudgetItemsRepository extends JpaRepository<MaterialBudgetItems, Integer> {
}
