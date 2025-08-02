package com.zaeta.core.employees.application;

import com.zaeta.core.employees.infrastructure.EmployeeAdapter;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.model.repository.EmployeeRepository;
import com.zaeta.core.employees.web.responses.output.GetAllEmployeesOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GetAllEmployeeUseCase {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    EmployeeAdapter adapter;

    public List<GetAllEmployeesOutput> getAllEmployeesActives(){
        log.info("Se han traido todos los empleados activos");



        return repository.findByEmployeeIsActive(true)
                .stream()
                .map(adapter::modelToOutput)
                .collect(Collectors.toList());
    }

}
