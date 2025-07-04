package com.moazmahmud.java_webflux_api.config;

import com.moazmahmud.java_webflux_api.model.HttpResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpResponseException.class)
    public Mono<ResponseEntity<?>> handleHttpResponseException(HttpResponseException ex, ServerHttpRequest request) {
        var errorObj = ex.getErrorObj(request);
        var status = ResponseEntity.status(ex.getHttpStatus()).body(errorObj);
        return Mono.just(status);
    }
}
