package com.zaeta.core.employees.web.responses;

import com.zaeta.core.employees.application.ModifiedEmployeeStatusUseCase;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.web.responses.output.GetEmployeesOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class ModifiedEmployeeStatusController {

    @Autowired
    ModifiedEmployeeStatusUseCase useCase;

    @PutMapping("/modifiedEmployeeStatus/{id}/{isActive}")
    public ResponseEntity<GetEmployeesOutput> modifiedEmployeeStatus(@PathVariable Long id, @PathVariable Boolean isActive){
        return ResponseEntity.ok(useCase.modifiedEmployeeById(id, isActive));
    }

}
