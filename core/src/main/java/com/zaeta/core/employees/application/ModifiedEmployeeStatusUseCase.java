package com.zaeta.core.employees.application;

import com.zaeta.core.employees.infrastructure.EmployeeAdapter;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.model.repository.EmployeeRepository;
import com.zaeta.core.employees.web.responses.output.GetEmployeesOutput;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ModifiedEmployeeStatusUseCase {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    EmployeeAdapter adapter;

    @Autowired
    GenericValidation genericValidation;

    public GetEmployeesOutput modifiedEmployeeById(Long id, Boolean isActive){

        genericValidation.validateNotEmpty(id.toString(), " El id no debe estar vacio");

        EmployeeModel existentEmployee = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El id no existe en la db"));

        if (existentEmployee.getEmployeeIsActive().equals(isActive)){
            genericValidation.errorValidation("El estatus del empleado es el mismo");
        }

        log.info("Empleado {}, modificado con el estatus de: {} a {}", existentEmployee.getEmployeeName(), existentEmployee.getEmployeeIsActive(), isActive);

        return adapter.modelToGetOutput(repository.save(adapter.modifiedEmployeeStatus(existentEmployee, isActive)));

    }

}
