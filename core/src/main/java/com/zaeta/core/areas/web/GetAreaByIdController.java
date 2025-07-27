package com.zaeta.core.areas.web;

import com.zaeta.core.areas.application.GetAreaByIdUseCase;
import com.zaeta.core.areas.model.AreaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/area")
public class GetAreaByIdController {

    @Autowired
    GetAreaByIdUseCase useCase;

    @GetMapping("/getAreaById/{id}")
    public ResponseEntity<AreaModel> getAreaById(@PathVariable Long id){
        return ResponseEntity.ok(useCase.getAreaById(id));
    }

}
