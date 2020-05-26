package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.LaborBudgetItems;

public interface LaborBudgetItemsRepository extends JpaRepository<LaborBudgetItems, Integer> {
}



