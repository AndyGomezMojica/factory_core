package com.zaeta.core.areas.web;

import com.zaeta.core.areas.application.ModifiedAreaStatusUseCase;
import com.zaeta.core.areas.model.AreaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/area")
public class ModifiedAreaByIdController {

    @Autowired
    ModifiedAreaStatusUseCase useCase;

    @PutMapping("/modifiedArea/{id}/{status}")
    public ResponseEntity<AreaModel> modifiedAreaById(@PathVariable Long id, @PathVariable Boolean status){
        return ResponseEntity.ok(useCase.modifiedAreaStatus(id, status));
    }
}
