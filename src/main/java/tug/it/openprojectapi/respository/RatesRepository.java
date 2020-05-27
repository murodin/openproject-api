package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.Rates;

public interface RatesRepository extends JpaRepository<Rates, Integer> {
    Rates findAllByCostTypeId(Integer costTypeId);
}
