package com.moazmahmud.java_webflux_api.api.projects;

import com.moazmahmud.java_webflux_api.model.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService service;

    @GetMapping
    public Mono<ApiResponse<List<ProjectDto>>> getAll() {
        return service.findAll()
                .collectList()
                .map(ApiResponse::of);
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse<ProjectDto>> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ApiResponse::of);
    }

    @PostMapping
    public Mono<ApiResponse<ProjectDto>> add(@RequestBody ProjectDto dto) {
        dto.setId(null);
        return service.add(dto)
                .map(ApiResponse::of);
    }

    @PutMapping("/{id}")
    public Mono<ApiResponse<ProjectDto>> update(@PathVariable String id, @RequestBody ProjectDto dto) {
        dto.setId(id);
        return service.update(dto)
                .map(ApiResponse::of);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return service.delete(id)
                .map((ignored) -> ResponseEntity.noContent().build());
    }
}
