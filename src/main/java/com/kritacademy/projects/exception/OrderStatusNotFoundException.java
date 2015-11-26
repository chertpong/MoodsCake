package com.kritacademy.projects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Chertpong on 21/11/2558.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderStatusNotFoundException extends RuntimeException{
    public OrderStatusNotFoundException() {
    }

    public OrderStatusNotFoundException(String message) {
        super(message);
    }

    public OrderStatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderStatusNotFoundException(Throwable cause) {
        super(cause);
    }

    public OrderStatusNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
