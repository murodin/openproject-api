package tug.it.openprojectapi.web.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tug.it.openprojectapi.model.ProjectsDto;
import tug.it.openprojectapi.service.ProjectService;

import java.util.Optional;

@Slf4j
@RequestMapping("api/v1/projects")
@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @ApiOperation(value = "Tüm Projeleri Getir", notes = "/api/v1/projects")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success|OK", response = ProjectsDto[].class),
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping()
    public ResponseEntity getProjects() {
        return Optional.ofNullable(projectService.getProjects())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
