package tug.it.openprojectapi.web.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tug.it.openprojectapi.domain.Projects;
import tug.it.openprojectapi.model.ProjectsDto;
import tug.it.openprojectapi.service.BudgetService;
import tug.it.openprojectapi.service.WorkPackagesService;

@Slf4j
public abstract class ProjectMapperDecorator implements ProjectMapper {

    private ProjectMapper projectMapper;
    private BudgetService budgetService;
    private WorkPackagesService workPackagesService;

    @Autowired
    private void setServices(BudgetService budgetService,
                             WorkPackagesService workPackagesService) {
        this.budgetService = budgetService;
        this.workPackagesService = workPackagesService;
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
        projectsDto.setWork_packages(workPackagesService.getAllByProjectId(projects.getId()));

        return projectsDto;
    }
}
