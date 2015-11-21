package com.kritacademy.projects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Chertpong on 21/11/2558.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CakeNotFound extends RuntimeException{
    public CakeNotFound() {
    }

    public CakeNotFound(String message) {
        super(message);
    }

    public CakeNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public CakeNotFound(Throwable cause) {
        super(cause);
    }

    public CakeNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
