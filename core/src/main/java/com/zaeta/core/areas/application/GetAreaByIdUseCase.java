package com.zaeta.core.areas.application;

import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.model.repository.AreaRepository;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class GetAreaByIdUseCase {

    @Autowired
    AreaRepository repository;

    @Autowired
    GenericValidation genericValidation;

    public AreaModel getAreaById(Long id){

        genericValidation.validateNotEmpty(id.toString(), "El id no puede estar vacio");

        log.info("El area con ID: {}, fue traido satisfactoriamente", id);

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id del area no existe en la DB"));

    }

}
