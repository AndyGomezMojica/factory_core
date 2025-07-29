package com.zaeta.core.employees.web.responses.input;

import com.zaeta.core.employees.model.Enums.EmployeeGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateInput {

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

    @Column(name = "employee_phone")
    private String employeePhone;
}
