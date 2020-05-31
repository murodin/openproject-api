package tug.it.openprojectapi.web.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tug.it.openprojectapi.domain.Projects;
import tug.it.openprojectapi.model.ProjectsDto;
import tug.it.openprojectapi.service.BudgetService;
import tug.it.openprojectapi.service.MembersService;

@Slf4j
public abstract class ProjectMapperDecorator implements ProjectMapper {

    private ProjectMapper projectMapper;
    private BudgetService budgetService;
    private MembersService membersService;

    @Autowired
    private void setServices(BudgetService budgetService,
                             MembersService membersService) {
        this.budgetService = budgetService;
        this.membersService = membersService;
    }

    @Autowired
    @Qualifier("delegate")
    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectsDto projectsToDto(Projects projects) {
        ProjectsDto projectsDto = projectMapper.projectsToDto(projects);
        projectsDto.setBudget(budgetService.getByProjectId(projects.getId()));
        projectsDto.setMembers(membersService.getAllByProjectId(projects.getId()));

        return projectsDto;
    }
}
