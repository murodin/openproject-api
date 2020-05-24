package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.Projects;

public interface ProjectRepository extends JpaRepository<Projects, Integer> {
}
