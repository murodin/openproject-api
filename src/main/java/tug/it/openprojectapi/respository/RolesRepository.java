package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
