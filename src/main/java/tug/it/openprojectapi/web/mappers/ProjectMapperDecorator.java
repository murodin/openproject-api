package tug.it.openprojectapi.web.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tug.it.openprojectapi.domain.Projects;
import tug.it.openprojectapi.model.ProjectsDto;

@Slf4j
public abstract class ProjectMapperDecorator implements ProjectMapper {

    private ProjectMapper projectMapper;

    @Autowired
    @Qualifier("delegate")
    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectsDto projectsToDto(Projects projects) {
        ProjectsDto projectsDto = projectMapper.projectsToDto(projects);
        // todo implemented with Budget Class
        projectsDto.setBudget(null);
        return projectsDto;
    }
}
