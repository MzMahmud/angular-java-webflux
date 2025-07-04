package com.moazmahmud.java_webflux_api.model;

import org.springframework.http.HttpStatus;

public class NotFoundResponseException extends HttpResponseException {
    public NotFoundResponseException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
