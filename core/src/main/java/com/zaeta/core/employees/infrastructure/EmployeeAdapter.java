package com.zaeta.core.employees.infrastructure;

import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.model.repository.AreaRepository;
import com.zaeta.core.employees.model.EmployeeModel;
import com.zaeta.core.employees.model.repository.EmployeeRepository;
import com.zaeta.core.employees.web.responses.input.CreateEmployeeInput;
import com.zaeta.core.employees.web.responses.input.ModifiedEmployeeInput;
import com.zaeta.core.employees.web.responses.output.GetAllEmployeesOutput;
import com.zaeta.core.employees.web.responses.output.GetEmployeesOutput;
import com.zaeta.core.roles.model.RoleModel;
import com.zaeta.core.roles.model.repository.RoleRepository;
import com.zaeta.core.utils.GenericValidation.GenericValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeAdapter {

    @Autowired
    GenericValidation genericValidation;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EmployeeRepository employeeRepository;

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

    public GetAllEmployeesOutput  modelToOutput(EmployeeModel employeeModel){
        return GetAllEmployeesOutput.builder()
                .employeeId(employeeModel.getEmployeeId())
                .employeeName(employeeModel.getEmployeeName())
                .employeeLastName(employeeModel.getEmployeeLastName())
                .employeeBirthPlace(employeeModel.getEmployeeBirthPlace())
                .employeeAddress(employeeModel.getEmployeeAddress())
                .employeeState(employeeModel.getEmployeeState())
                .employeeZipCode(employeeModel.getEmployeeZipCode())
                .employeeGender(employeeModel.getEmployeeGender())
                .employee_marital_status(employeeModel.getEmployee_marital_status())
                .employeePhone(employeeModel.getEmployeePhone())
                .employeeCurp(employeeModel.getEmployeeCurp())
                .employeeRfc(employeeModel.getEmployeeRfc())
                .employeeNss(employeeModel.getEmployeeNss())
                .areaName(employeeModel.getArea().getAreaName())
                .rolesName(employeeModel.getRoles().stream()
                        .map(RoleModel::getRoleName)
                        .collect(Collectors.toList()))
                .build();
    }

    public GetEmployeesOutput modelToGetOutput(EmployeeModel employeeModel){
        return GetEmployeesOutput.builder()
                .employeeId(employeeModel.getEmployeeId())
                .employeeName(employeeModel.getEmployeeName())
                .employeeLastName(employeeModel.getEmployeeLastName())
                .employeeBirthPlace(employeeModel.getEmployeeBirthPlace())
                .employeeAddress(employeeModel.getEmployeeAddress())
                .employeeState(employeeModel.getEmployeeState())
                .employeeZipCode(employeeModel.getEmployeeZipCode())
                .employeeGender(employeeModel.getEmployeeGender())
                .employee_marital_status(employeeModel.getEmployee_marital_status())
                .employeePhone(employeeModel.getEmployeePhone())
                .employeeCurp(employeeModel.getEmployeeCurp())
                .employeeRfc(employeeModel.getEmployeeRfc())
                .employeeNss(employeeModel.getEmployeeNss())
                .employeeIsActive(employeeModel.getEmployeeIsActive())
                .areaName(employeeModel.getArea().getAreaName())
                .rolesName(employeeModel.getRoles().stream()
                        .map(RoleModel::getRoleName)
                        .collect(Collectors.toList()))
                .build();
    }

    public EmployeeModel modifiedInputToModel(EmployeeModel existentEmployee, ModifiedEmployeeInput input){

        AreaModel existentArea = areaRepository.findById(input.getAreaId())
                .orElseThrow(() -> new EntityNotFoundException("El id del area no existe en la DB"));

        List<RoleModel> roles = new ArrayList<>();

        if (input.getRolesIds() != null && !input.getRolesIds().isEmpty()){
            roles = roleRepository.findAllById(input.getRolesIds());
            if (roles.size() != input.getRolesIds().size()){
                genericValidation.errorValidation("Algunos roles no existen en la db");
            }
        }

        existentEmployee.setEmployeeName(input.getEmployeeName().toUpperCase());
        existentEmployee.setEmployeeLastName(input.getEmployeeLastName().toUpperCase());
        existentEmployee.setEmployeeBirthPlace(input.getEmployeeBirthPlace());
        existentEmployee.setEmployeeAddress(input.getEmployeeAddress());
        existentEmployee.setEmployeeState(input.getEmployeeState());
        existentEmployee.setEmployeeZipCode(input.getEmployeeZipCode());
        existentEmployee.setEmployeeGender(input.getEmployeeGender());
        existentEmployee.setEmployee_marital_status(input.getEmployee_marital_status().toUpperCase());
        existentEmployee.setEmployeeCurp(input.getEmployeeCurp().toUpperCase());
        existentEmployee.setEmployeeRfc(input.getEmployeeRfc().toUpperCase());
        existentEmployee.setEmployeeNss(input.getEmployeeNss().toUpperCase());
        existentEmployee.setEmployeePhone(input.getEmployeePhone());
        existentEmployee.setEmployeeIsActive(input.getEmployeeIsActive());
        existentEmployee.setEmployeeModifiedAt(new Date());
        existentEmployee.setArea(existentArea);
        existentEmployee.setRoles(roles);

        return existentEmployee;
    }

    public EmployeeModel modifiedEmployeeStatus(EmployeeModel existentEmployee, Boolean isActive){

        existentEmployee.setEmployeeModifiedAt(new Date());
        existentEmployee.setEmployeeIsActive(isActive);

        return existentEmployee;

    }
}
