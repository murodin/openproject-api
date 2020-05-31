package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tug.it.openprojectapi.domain.Projects;
import tug.it.openprojectapi.exception.ProjectNotFoundException;
import tug.it.openprojectapi.model.ProjectsDto;
import tug.it.openprojectapi.respository.ProjectRepository;
import tug.it.openprojectapi.web.mappers.ProjectMapper;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final WorkPackagesService workPackagesService;
    private final ProjectMapper projectMapper;

    public List<ProjectsDto> getProjects() {
        List<Projects> projectsList = Optional.ofNullable(projectRepository.findAll())
                .orElseThrow(() -> new ProjectNotFoundException("No Projects Found"));

        return projectsList.stream()
                .map(projectMapper::projectsToDto)
                .collect(toList());
    }

    public List<ProjectsDto> getProjectsByActive(boolean active) {
        List<Projects> projectsList = Optional.ofNullable(projectRepository.findAllByActive(active))
                .orElseThrow(() -> new ProjectNotFoundException("No Projects Found"));

        return projectsList.stream()
                .map(projectMapper::projectsToDto)
                .collect(toList());
    }

    public ProjectsDto getProjectsByIdAndActive(Integer projectId, boolean status) {
        Projects projects = projectRepository.findByIdAndActive(projectId, status)
                .orElseThrow(() -> new ProjectNotFoundException(String.format("No Projects Found for Project Id %d and Status %s", projectId, status)));

        ProjectsDto projectsDto = projectMapper.projectsToDto(projects);
        projectsDto.setWork_packages(workPackagesService.getAllByProjectId(projectId));

        return projectsDto;
    }
}
