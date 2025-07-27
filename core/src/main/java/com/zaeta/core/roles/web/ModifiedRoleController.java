package com.zaeta.core.roles.web;

import com.zaeta.core.roles.application.ModifiedRoleUseCase;
import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.web.responses.input.ModifiedRoleInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
public class ModifiedRoleController {

    @Autowired
    ModifiedRoleUseCase useCase;

    @PutMapping("/modifiedRole/{id}")
    public ResponseEntity<RoleModel> modifiedExistentRole(@PathVariable Long id, @RequestBody ModifiedRoleInput input){

        return ResponseEntity.ok(useCase.modifiedExistentRole(id, input));

    }
}
