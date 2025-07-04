package com.moazmahmud.java_webflux_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;

    public static <T> ApiResponse<T> of(T data) {
        return new ApiResponse<>(data);
    }
}
