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

    public void validateLengthString(String fieldName, String value, Integer length){

        validateNotNull(value, "El valor no puede ser nulo");
        validateNotEmpty(value, " El valor no puede estar vacio");
        validateNotNull(length, "El tamaño no puede ser nulo");

        if (length <= 0){
            errorValidation("El tamaño debe ser mayor a cero");
        }

        if (value.length() != length){
            errorValidation("El tamaño de " + fieldName +  " :(" + value.length() + ") no coincide con el tamaño requerido :(" + length + ")");
        }
    }
}
