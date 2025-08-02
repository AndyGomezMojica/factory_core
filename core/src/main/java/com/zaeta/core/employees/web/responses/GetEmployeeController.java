package com.zaeta.core.employees.web.responses;

import com.zaeta.core.employees.application.GetEmployeeUseCase;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.web.responses.output.GetEmployeesOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class GetEmployeeController {

    @Autowired
    GetEmployeeUseCase useCase;

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<GetEmployeesOutput> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(useCase.getEmployeeById(id));
    }

}
