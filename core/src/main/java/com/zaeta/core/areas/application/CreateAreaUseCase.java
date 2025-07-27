package com.zaeta.core.areas.application;

import com.zaeta.core.areas.infrastructure.AreaAdapter;
import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.model.repository.AreaRepository;
import com.zaeta.core.areas.web.responses.input.CreateAreaInput;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateAreaUseCase {

    @Autowired
    AreaRepository repository;

    @Autowired
    GenericValidation genericValidation;

    @Autowired
    AreaAdapter adapter;

    public AreaModel createArea(CreateAreaInput input){

        genericValidation.validateNotNull(input, "Los valores de area no pueden estar nulos");
        genericValidation.validateNotEmpty(input.getAreaName(), "El nombre del area no puede estar vacio");

        if (repository.existsByAreaName(input.getAreaName().toUpperCase())){
            genericValidation.errorValidation("Area existente en la DB, no puede duplicarse");
        }

        log.info("Area: {}, creada satisfactoriamente", input.getAreaName().toUpperCase());
        return repository.save(adapter.inputAreaToModel(input));




    }

}
