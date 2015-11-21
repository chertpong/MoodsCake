package com.kritacademy.projects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Chertpong on 21/11/2558.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DateIsInvalidException extends RuntimeException{
    public DateIsInvalidException() {
    }

    public DateIsInvalidException(String message) {
        super(message);
    }

    public DateIsInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateIsInvalidException(Throwable cause) {
        super(cause);
    }

    public DateIsInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
