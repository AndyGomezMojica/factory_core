package com.zaeta.core.roles.application;

import com.zaeta.core.roles.infrastructure.RoleAdapter;
import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.model.repository.RoleRepository;
import com.zaeta.core.roles.web.responses.input.ModifiedRoleInput;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Slf4j
@Service
public class ModifiedRoleUseCase {

    @Autowired
    RoleRepository repository;

    @Autowired
    GenericValidation genericValidation;

    @Autowired
    RoleAdapter adapter;

    public RoleModel modifiedExistentRole(Long id, ModifiedRoleInput input){

        genericValidation.validateNotNull(input, "El input no puede estar vacio");
        genericValidation.validateNotEmpty(id.toString(), "El rol no debe estar vacio");

        RoleModel existentRole = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado con ID: " + id));

        log.info("Rol: {}, modificado exitosamente, ahora como: {}, con estatus: {}", existentRole.getRoleName().toUpperCase(), input.getRoleName().toUpperCase(), input.getRoleIsActive());
        return repository.save(adapter.modifiedInputToModel(existentRole, input));
    }

}
