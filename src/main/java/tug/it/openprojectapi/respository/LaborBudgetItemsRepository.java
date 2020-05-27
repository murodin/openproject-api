package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.LaborBudgetItems;

import java.util.List;

public interface LaborBudgetItemsRepository extends JpaRepository<LaborBudgetItems, Integer> {
    List<LaborBudgetItems> findAllByCostObjectId(Integer costObjectId);
}



