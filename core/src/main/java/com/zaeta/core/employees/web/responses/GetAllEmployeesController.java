package com.zaeta.core.employees.web.responses;

import com.zaeta.core.employees.application.GetAllEmployeeUseCase;
import com.zaeta.core.employees.web.responses.output.GetAllEmployeesOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class GetAllEmployeesController {

    @Autowired
    GetAllEmployeeUseCase useCase;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<GetAllEmployeesOutput>> getAllEmployeeActive(){
        return ResponseEntity.ok(useCase.getAllEmployeesActives());
    }

}
