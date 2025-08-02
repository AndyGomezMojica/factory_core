package com.zaeta.core.employees.infrastructure;

import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.model.repository.AreaRepository;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.web.responses.input.CreateEmployeeInput;
import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.model.repository.RoleRepository;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeAdapter {

    @Autowired
    GenericValidation genericValidation;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    RoleRepository roleRepository;

    public EmployeeModel createInputToModel(CreateEmployeeInput input){

        genericValidation.validateNotNull(input, "El objeto no puede ser nulo");
        genericValidation.validateNotEmpty(input.getAreaId().toString(), "El id del area no debe estar vacio");

        AreaModel existentArea = areaRepository.findById(input.getAreaId())
                .orElseThrow(() -> new RuntimeException("El id del area no existe en la db"));

        List<RoleModel> roles = new ArrayList<>();

        if (input.getRolesIds() != null && !input.getRolesIds().isEmpty()){
            roles = roleRepository.findAllById(input.getRolesIds());
            if (roles.size() != input.getRolesIds().size()){
                genericValidation.errorValidation("Algunos roles no existen en la db");
            }
        }

        return EmployeeModel.builder()
                .employeeName(input.getEmployeeName().toUpperCase())
                .employeeLastName(input.getEmployeeLastName().toUpperCase())
                .employeeBirthPlace(input.getEmployeeBirthPlace())
                .employeeAddress(input.getEmployeeAddress())
                .employeeState(input.getEmployeeState())
                .employeeZipCode(input.getEmployeeZipCode())
                .employeeGender(input.getEmployeeGender())
                .employee_marital_status(input.getEmployee_marital_status().toUpperCase())
                .employeeCurp(input.getEmployeeCurp().toUpperCase())
                .employeeRfc(input.getEmployeeRfc().toUpperCase())
                .employeeNss(input.getEmployeeNss().toUpperCase())
                .employeePhone(input.getEmployeePhone())
                .employeeCreatedAt(new Date())
                .employeeIsActive(true)
                .area(existentArea)
                .roles(roles)
                .build();
    }
}
