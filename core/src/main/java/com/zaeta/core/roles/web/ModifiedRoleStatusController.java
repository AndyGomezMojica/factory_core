package com.zaeta.core.roles.web;

import com.zaeta.core.roles.application.ModifiedRoleStatusUseCase;
import com.zaeta.core.roles.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
public class ModifiedRoleStatusController {

    @Autowired
    ModifiedRoleStatusUseCase useCase;

    @PutMapping("/modifiedRoleStatus/{id}/{status}")
    public ResponseEntity<RoleModel> modifiedRoleStatus(@PathVariable Long id, @PathVariable Boolean status){
        return ResponseEntity.ok(useCase.modifiedRoleStatus(id, status));
    }
}
