package com.zaeta.core.employees.web.responses;

import com.zaeta.core.employees.application.CreateEmployeeUseCase;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.web.responses.input.CreateEmployeeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class CreateEmployeeController {

    @Autowired
    CreateEmployeeUseCase useCase;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody CreateEmployeeInput input){
        return ResponseEntity.ok(useCase.createEmployee(input));
    }

}
