package com.moazmahmud.java_webflux_api.model;

import com.moazmahmud.java_webflux_api.config.TimeConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Map;

public class HttpResponseException extends RuntimeException {
    public HttpResponseException(String message) {
        super(message);
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    public Map<String, Object> getErrorObj(ServerHttpRequest request) {
        HttpStatus httpStatus = getHttpStatus();
        return Map.of(
                "requestId", request.getId(),
                "path", request.getPath().value(),
                "time", TimeConfig.now(),
                "errorCode", httpStatus.value(),
                "error", httpStatus.name(),
                "message", getMessage()
        );
    }
}
