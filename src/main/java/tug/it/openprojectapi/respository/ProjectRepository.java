package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.Projects;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Projects, Integer> {
    List<Projects> findAllByActive(boolean active);
    Optional<Projects> findByIdAndActive(Integer integer, boolean active);
}
