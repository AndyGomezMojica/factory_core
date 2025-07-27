package com.zaeta.core.roles.application;

import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.model.repository.RoleRepository;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class GetRoleUseCase {

    @Autowired
    RoleRepository repository;

    @Autowired
    GenericValidation genericValidation;

    public RoleModel getRoleById(Long id){

        genericValidation.validateNotEmpty(id.toString(), "El id no puede estar vacio");

        RoleModel existentRoleId = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El id no existe en la DB"));

        log.info("Rol {}, con ID {}, existente en la DB", existentRoleId.getRoleName(), id);
        return existentRoleId;

    }

}
