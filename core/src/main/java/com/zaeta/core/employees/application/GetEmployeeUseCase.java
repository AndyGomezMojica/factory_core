package com.zaeta.core.employees.application;

import com.zaeta.core.employees.infrastructure.EmployeeAdapter;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.model.repository.EmployeeRepository;
import com.zaeta.core.employees.web.responses.output.GetEmployeesOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class GetEmployeeUseCase {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    EmployeeAdapter adapter;

    public GetEmployeesOutput getEmployeeById(Long id){
        log.info("El empleado con id: {}, traido exitosamente");
        EmployeeModel existentEmployee = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El id no existe en la DB"));

        return adapter.modelToGetOutput(existentEmployee);
    }

}
