package com.zaeta.core.areas.web;

import com.zaeta.core.areas.application.GetAllAreasUseCase;
import com.zaeta.core.areas.model.AreaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/area")
public class GetAllAreasController {

    @Autowired
    GetAllAreasUseCase useCase;

    @GetMapping("/getAllAreas")
    public ResponseEntity<List<AreaModel>> getAllAreas(){
        return ResponseEntity.ok(useCase.getAllAreas());
    }
}
