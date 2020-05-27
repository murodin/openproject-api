package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.MaterialBudgetItems;

import java.util.List;

public interface MaterialBudgetItemsRepository extends JpaRepository<MaterialBudgetItems, Integer> {
    List<MaterialBudgetItems> findAllByCostObjectId(Integer costObjectId);
}
