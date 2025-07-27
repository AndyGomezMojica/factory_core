package com.zaeta.core.roles.application;

import com.zaeta.core.roles.infrastructure.RoleAdapter;
import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.model.repository.RoleRepository;
import com.zaeta.core.roles.web.responses.input.CreateRoleInput;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateRoleUseCase {

    @Autowired
    RoleRepository repository;

    @Autowired
    RoleAdapter adapter;

    @Autowired
    GenericValidation genericValidation;

    public RoleModel createRole(CreateRoleInput input){

        genericValidation.validateNotNull(input, "Rol no puede ser nulo");
        genericValidation.validateNotEmpty(input.getRoleName(), "Nombre del rol no debe estar vacio");

        String roleName = input.getRoleName().toUpperCase();

        if (repository.existsByRoleName(roleName)){
            genericValidation.errorValidation("Rol existente en la db, no se puede duplicar");
        }

        log.info("Rol {}, creado satisfactoriamente", input.getRoleName());
        return repository.save(adapter.inputToModel(input));

    }

}
