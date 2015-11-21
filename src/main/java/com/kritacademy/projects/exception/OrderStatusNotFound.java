package com.kritacademy.projects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Chertpong on 21/11/2558.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderStatusNotFound extends RuntimeException{
    public OrderStatusNotFound() {
    }

    public OrderStatusNotFound(String message) {
        super(message);
    }

    public OrderStatusNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderStatusNotFound(Throwable cause) {
        super(cause);
    }

    public OrderStatusNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
