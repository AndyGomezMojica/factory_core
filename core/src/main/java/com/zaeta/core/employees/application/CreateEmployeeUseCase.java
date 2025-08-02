package com.zaeta.core.employees.application;

import com.zaeta.core.employees.infrastructure.EmployeeAdapter;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.model.repository.EmployeeRepository;
import com.zaeta.core.employees.web.responses.input.CreateEmployeeInput;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateEmployeeUseCase {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    GenericValidation genericValidation;

    @Autowired
    EmployeeAdapter adapter;

    public EmployeeModel createEmployee(CreateEmployeeInput input){

        genericValidation.validateNotNull(input, "El objeto empleado no puede ser nulo");
        genericValidation.validateNotEmpty(input.getEmployeeName(), " El nombre no puede estar vacio");
        genericValidation.validateNotEmpty(input.getEmployeeCurp(), "El curp no puede estar vacio");
        genericValidation.validateNotEmpty(input.getEmployeeRfc(), " El rfc no puede estar vacio");
        genericValidation.validateNotEmpty(input.getEmployeeNss(), " El nss no puede estar vacio");

        if (repository.existsByEmployeeCurp(input.getEmployeeCurp().toUpperCase())){
            genericValidation.errorValidation("Ya existe un empleado con el curp: " + input.getEmployeeCurp().toUpperCase());
        }

        genericValidation.validateLengthString(input.getEmployeeCurp(), 18);

        if (repository.existsByEmployeeRfc(input.getEmployeeRfc().toUpperCase())){
            genericValidation.errorValidation("Ya existe un empleado con el rfc: " + input.getEmployeeRfc().toUpperCase());
        }

        genericValidation.validateLengthString(input.getEmployeeRfc(),13);

        if (repository.existsByEmployeeNss(input.getEmployeeNss().toUpperCase())){
            genericValidation.errorValidation("Ya existe un empleado con el nss: " + input.getEmployeeNss().toUpperCase());
        }

        genericValidation.validateLengthString(input.getEmployeeNss(), 11);

        genericValidation.validateLengthString(input.getEmployeeZipCode().toString(), 5);

        log.info("El empleado: {} ha sido creado exitosamente", input.getEmployeeName());
        return repository.save(adapter.createInputToModel(input));
    }
}
