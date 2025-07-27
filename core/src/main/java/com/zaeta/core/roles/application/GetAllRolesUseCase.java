package com.zaeta.core.roles.application;

import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.model.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GetAllRolesUseCase {

    @Autowired
    RoleRepository repository;

    public List<RoleModel> getAllRoles(){
        log.info("Se han traido todos los roles existentes activos");
        return repository.findByRoleIsActive(true);
    }

}
