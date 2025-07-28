package com.zaeta.core.areas.application;

import com.zaeta.core.areas.infrastructure.AreaAdapter;
import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.model.repository.AreaRepository;
import com.zaeta.core.areas.web.responses.input.ModifiedAreaInput;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class ModifiedAreaUseCase {

    @Autowired
    AreaRepository repository;

    @Autowired
    GenericValidation genericValidation;

    @Autowired
    AreaAdapter adapter;

    public AreaModel modifiedArea(Long id, ModifiedAreaInput input){

        genericValidation.validateNotNull(input, "Los valores del area no pueden estar nulos");
        genericValidation.validateNotEmpty(id.toString(), "El id no puede estar vacio");

        AreaModel existentArea = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe en la DB el area con el id: "+ id));

        if (existentArea.getAreaName().equals(input.getAreaName().toUpperCase())){
            log.info("El area: {} ya tenia el nombre: {}", existentArea.getAreaName(), input.getAreaName().toUpperCase());
            return existentArea;
        }

        log.info("Area: {}, modificado exitosamente, ahora como: {}, con estatus: {}", existentArea.getAreaName().toUpperCase(), input.getAreaName().toUpperCase(), input.getAreaIsActive());

        return repository.save(adapter.modifiedInputToModel(existentArea, input));

    }

}
