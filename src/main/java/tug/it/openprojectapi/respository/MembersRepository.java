package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.Members;

import java.util.List;

public interface MembersRepository extends JpaRepository<Members, Integer> {
    List<Members> findAllByProjectId(Integer projectId);
}
