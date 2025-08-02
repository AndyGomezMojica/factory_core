package com.zaeta.core.employees.web.responses;

import com.zaeta.core.employees.application.ModifiedEmployeeUseCase;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.web.responses.input.ModifiedEmployeeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class ModifiedEmployeeController {

    @Autowired
    ModifiedEmployeeUseCase useCase;

    @PutMapping("/modifiedEmployee/{id}")
    public ResponseEntity<EmployeeModel> modifiedEmployee(@PathVariable Long id, @RequestBody ModifiedEmployeeInput input){
        return ResponseEntity.ok(useCase.modifiedEmployee(id,input));
    }

}
