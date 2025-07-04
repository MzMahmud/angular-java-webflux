package com.moazmahmud.java_webflux_api.api.projects;

import com.moazmahmud.java_webflux_api.model.NotFoundResponseException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class ProjectService {
    private final ConcurrentLinkedQueue<ProjectDto> projectDtos = new ConcurrentLinkedQueue<>();

    public Flux<ProjectDto> findAll() {
        return Flux.fromIterable(projectDtos);
    }

    public Mono<ProjectDto> findById(String id) {
        return Flux.fromIterable(projectDtos)
                .filter(project -> project.getId().equals(id))
                .next()
                .switchIfEmpty(Mono.error(new NotFoundResponseException(String.format("Project with id=%s not found", id))));
    }

    public Mono<ProjectDto> add(ProjectDto dto) {
        dto.setId(UUID.randomUUID().toString());
        projectDtos.add(dto);
        return Mono.just(dto);
    }

    public Mono<ProjectDto> update(ProjectDto dto) {
        return findById(dto.getId())
                .doOnNext(dst -> update(dto, dst));
    }

    private void update(ProjectDto src, ProjectDto dst) {
        BeanUtils.copyProperties(src, dst);
    }

    public Mono<Void> delete(String id) {
        return findById(id)
                .doOnNext(projectDtos::remove)
                .then();
    }

    public ServerSentEvent<ProjectDto> convertToServerSentEvent(ProjectDto dto) {
        return ServerSentEvent.<ProjectDto>builder()
                .id(dto.getId())
                .data(dto)
                .build();
    }
}
