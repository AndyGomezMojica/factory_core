package com.zaeta.core.utils.GenericValidation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class GenericValidation {

    public void validateNotNull(Object object, String errorMessage){
        if (object == null){
            errorValidation(errorMessage);
        }
    }

    public void validateNotEmpty(String value, String errorMessage){
        if (value.isEmpty() || value.trim().isEmpty()){
            errorValidation(errorMessage);
        }
    }

    public void errorValidation(String errorMessage){
        log.error(errorMessage);
        throw new IllegalArgumentException(errorMessage);
    }
}
