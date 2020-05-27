package tug.it.openprojectapi.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tug.it.openprojectapi.domain.Projects;
import tug.it.openprojectapi.model.ProjectsDto;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(ProjectMapperDecorator.class)
public interface ProjectMapper {

    @Mapping(source = "parentId", target = "parent_id")
    @Mapping(source = "createdAt", target = "created_at")
    @Mapping(source = "updatedAt", target = "updated_at")
    ProjectsDto projectsToDto(Projects projects);

    @Mapping(source = "parent_id", target = "parentId")
    @Mapping(source = "created_at", target = "createdAt")
    @Mapping(source = "updated_at", target = "updatedAt")
    Projects dtoToProjects(ProjectsDto projectDto);
}