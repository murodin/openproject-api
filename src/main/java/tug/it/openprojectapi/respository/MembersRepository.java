package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.Members;

public interface MembersRepository extends JpaRepository<Members, Integer> {
}
