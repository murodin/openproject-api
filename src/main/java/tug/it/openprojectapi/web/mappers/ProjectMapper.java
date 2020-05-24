package tug.it.openprojectapi.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import tug.it.openprojectapi.domain.Projects;
import tug.it.openprojectapi.model.ProjectsDto;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(ProjectMapperDecorator.class)
public interface ProjectMapper {
    ProjectsDto projectsToDto(Projects projects);

    Projects dtoToProjects(ProjectsDto projectDto);
}