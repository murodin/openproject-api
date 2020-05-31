package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
