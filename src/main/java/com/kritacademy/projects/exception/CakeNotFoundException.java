package com.kritacademy.projects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Chertpong on 21/11/2558.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CakeNotFoundException extends RuntimeException{
    public CakeNotFoundException() {
    }

    public CakeNotFoundException(String message) {
        super(message);
    }

    public CakeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CakeNotFoundException(Throwable cause) {
        super(cause);
    }

    public CakeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
