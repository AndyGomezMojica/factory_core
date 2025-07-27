package com.zaeta.core.roles.infrastructure;

import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.web.responses.input.CreateRoleInput;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoleAdapter {

    @Autowired
    GenericValidation genericValidation;

    public RoleModel inputToModel(CreateRoleInput input){

        genericValidation.validateNotNull(input, "El input no puede estar vacio");

        return RoleModel.builder()
                .roleName(input.getRoleName().toUpperCase())
                .roleDescription(input.getRoleDescription())
                .roleCreatedAt(new Date())
                .roleIsActive(true)
                .build();
    }

}
