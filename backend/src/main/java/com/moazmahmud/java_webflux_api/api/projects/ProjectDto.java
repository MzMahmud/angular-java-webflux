package com.moazmahmud.java_webflux_api.api.projects;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private String id;
    private String name;
    private String owner;
    private ProjectStatus status;
}
