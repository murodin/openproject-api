package tug.it.openprojectapi.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tug.it.openprojectapi.service.ProjectService;

import java.util.Optional;

@Slf4j
@RequestMapping("api/v1/projects")
@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping()
    public ResponseEntity getProjects() {
        return Optional.ofNullable(projectService.getProjects())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
