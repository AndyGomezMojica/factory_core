package com.zaeta.core.roles.web;

import com.zaeta.core.roles.application.GetRoleUseCase;
import com.zaeta.core.roles.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class GetRoleByIdController {

    @Autowired
    GetRoleUseCase useCase;

    @GetMapping("getRoleById/{id}")
    public ResponseEntity<RoleModel> getRoleById(@PathVariable Long id){
        return ResponseEntity.ok(useCase.getRoleById(id));
    }
}
