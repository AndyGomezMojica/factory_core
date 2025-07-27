package com.zaeta.core.roles.web;

import com.zaeta.core.roles.application.CreateRoleUseCase;
import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.web.responses.input.CreateRoleInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class CreateRoleController {

    @Autowired
    CreateRoleUseCase useCase;

    @PostMapping("/createRole")
    public ResponseEntity<RoleModel> createRole(@RequestBody CreateRoleInput input){
        return ResponseEntity.ok(useCase.createRole(input));
    }

}
