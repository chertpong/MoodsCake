package com.kritacademy.projects.config.message;

import com.kritacademy.projects.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chertpong on 20/11/2558.
 */
@ControllerAdvice
public class ControllerValidationHandler {
    @Autowired
    private MessageSource messageSource;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<MessageDTO> processedValidationError(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        return processFieldError(fieldErrors);
    }

    private List<MessageDTO> processFieldError(List<FieldError> fieldErrors){
        List<MessageDTO> result = new ArrayList<>();
        fieldErrors.forEach(fieldError -> {
            if(fieldError!=null){
                MessageDTO messageDTO = null;
                Locale currentLocale = LocaleContextHolder.getLocale();
                String msg = messageSource.getMessage(fieldError.getDefaultMessage(),null, currentLocale);
                messageDTO = new MessageDTO("ERROR",msg);
                result.add(messageDTO);
            }
        });
        return result;
    }
}
