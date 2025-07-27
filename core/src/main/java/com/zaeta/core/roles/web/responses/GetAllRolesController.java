package com.zaeta.core.roles.web.responses;

import com.zaeta.core.roles.application.GetAllRolesUseCase;
import com.zaeta.core.roles.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class GetAllRolesController {

    @Autowired
    GetAllRolesUseCase getAllRolesUseCase;

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<RoleModel>> getAllRoles(){
        return ResponseEntity.ok(getAllRolesUseCase.getAllRoles());
    }

}
