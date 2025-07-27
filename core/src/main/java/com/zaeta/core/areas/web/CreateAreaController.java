package com.zaeta.core.areas.web;

import com.zaeta.core.areas.application.CreateAreaUseCase;
import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.web.responses.input.CreateAreaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/area")
public class CreateAreaController {

    @Autowired
    CreateAreaUseCase useCase;

    @PostMapping("/createArea")
    public ResponseEntity<AreaModel> createArea(@RequestBody CreateAreaInput input){
        return ResponseEntity.ok(useCase.createArea(input));
    }
}
