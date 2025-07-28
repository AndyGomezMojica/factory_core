package com.zaeta.core.areas.application;

import com.zaeta.core.areas.infrastructure.AreaAdapter;
import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.model.repository.AreaRepository;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class ModifiedAreaStatusUseCase {

    @Autowired
    AreaRepository repository;

    @Autowired
    GenericValidation genericValidation;

    @Autowired
    AreaAdapter adapter;

    public AreaModel modifiedAreaStatus(Long id, Boolean status){

        genericValidation.validateNotNull(id, "El id no debe estar nulo");
        genericValidation.validateNotEmpty(id.toString(), "El id no debe estar vacio");
        genericValidation.validateNotNull(status, "El estatus no debe estar nulo");
        genericValidation.validateNotEmpty(status.toString(), "El estatus no debe estar vacio");

        AreaModel existentArea = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Area no existente en la DB con el ID: " + id));

        if (existentArea.getAreaIsActive().equals(status)){
            log.debug("El area {} ya tenia el estatus {}", existentArea.getAreaName(), status);
            return existentArea;
        }

        log.info("Area {}, se modifico su estatus de: {} a {}", existentArea.getAreaName(), existentArea.getAreaIsActive(), status);
        return repository.save(adapter.modifiedAreaStatus(existentArea, status));

    }

}

