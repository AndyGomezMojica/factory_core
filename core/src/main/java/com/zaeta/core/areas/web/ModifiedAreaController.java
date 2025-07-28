package com.zaeta.core.areas.web;

import com.zaeta.core.areas.application.ModifiedAreaUseCase;
import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.web.responses.input.ModifiedAreaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/area")
public class ModifiedAreaController {

    @Autowired
    ModifiedAreaUseCase useCase;

    @PutMapping("/modifiedArea/{id}")
    public ResponseEntity<AreaModel> modifiedArea(@PathVariable Long id, @RequestBody ModifiedAreaInput input){
        return ResponseEntity.ok(useCase.modifiedArea(id, input));
    }

}
