package com.zaeta.core.roles.application;

import com.zaeta.core.roles.infrastructure.RoleAdapter;
import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.model.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class ModifiedRoleStatusUseCase {

    @Autowired
    RoleRepository repository;

    @Autowired
    RoleAdapter adapter;

    public RoleModel modifiedRoleStatus(Long id, Boolean status){

        RoleModel existentRole = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id no existe en la DB"));

        if (existentRole.getRoleIsActive().equals(status)){
            log.debug("El rol {} ya tenia el estatus {}", existentRole.getRoleIsActive(), status);
            return existentRole;
        }

        log.info("Rol {}, se modifico su estatus de: {} a {}", existentRole.getRoleName(), existentRole.getRoleIsActive(), status);
        return repository.save(adapter.modifiedRoleStatus(existentRole ,status));

    }

}
