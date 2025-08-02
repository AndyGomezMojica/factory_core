package com.zaeta.core.employees.application;

import com.zaeta.core.employees.infrastructure.EmployeeAdapter;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.model.repository.EmployeeRepository;
import com.zaeta.core.employees.web.responses.input.ModifiedEmployeeInput;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class ModifiedEmployeeUseCase {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    GenericValidation genericValidation;

    @Autowired
    EmployeeAdapter adapter;

    public EmployeeModel modifiedEmployee(Long id, ModifiedEmployeeInput input){

        genericValidation.validateNotNull(input, " El objeto input no debe estar vacio");
        genericValidation.validateNotEmpty(id.toString(), "El id no debe estar vacio");

        EmployeeModel existentEmployee = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El id del empleado no existe en la DB"));

        log.info("Empleado: {}, modificado exitosamente, ahora como: {}, con estatus: {}", existentEmployee.getEmployeeName().toUpperCase(), input.getEmployeeName().toUpperCase(), input.getEmployeeIsActive());
        return repository.save(adapter.modifiedInputToModel(existentEmployee, input));

    }

}
