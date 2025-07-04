package com.moazmahmud.java_webflux_api.api.projects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ProjectStatus {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String label;

    ProjectStatus(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static ProjectStatus fromLabel(String label) {
        return Arrays.stream(ProjectStatus.values())
                .filter(status -> status.label.equalsIgnoreCase(label))
                .findAny()
                .orElse(null);
    }
}
