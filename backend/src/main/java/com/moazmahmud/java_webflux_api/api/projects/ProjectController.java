package com.moazmahmud.java_webflux_api.api.projects;

import com.moazmahmud.java_webflux_api.model.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @GetMapping
    public Mono<ApiResponse<List<ProjectDto>>> getProjects() {
        var projects = List.of(new ProjectDto("1", "One", "One One", ProjectStatus.IN_PROGRESS));
        return Mono.just(ApiResponse.of(projects));
    }
}
