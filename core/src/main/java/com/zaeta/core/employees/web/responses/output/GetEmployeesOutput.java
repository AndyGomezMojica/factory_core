package com.zaeta.core.employees.web.responses.output;

import com.zaeta.core.employees.model.Enums.EmployeeGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeesOutput {

    private Long employeeId;
    private String employeeName;
    private String employeeLastName;
    private String employeeBirthPlace;
    private String employeeAddress;
    private String employeeState;
    private Integer employeeZipCode;
    private EmployeeGender employeeGender;
    private String employee_marital_status;
    private String employeeCurp;
    private String employeeRfc;
    private String employeeNss;
    private String employeePhone;
    private String areaName;
    private List<String> rolesName;
}
