package com.zaeta.core.employees.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.employees.model.Enums.EmployeeGender;
import com.zaeta.core.roles.model.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class EmployeeModel {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "employee_name", length = 100, nullable = false)
    private String employeeName;

    @Column(name = "employee_last_name", length = 200)
    private String employeeLastName;

    @Column(name = "employee_birth_place")
    private String employeeBirthPlace;

    @Column(name = "employee_address")
    private String employeeAddress;

    @Email
    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_state")
    private String employeeState;

    @Column(name = "employee_zip_code", length = 5)
    private Integer employeeZipCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_gender")
    private EmployeeGender employeeGender;

    @Column(name = "employee_marital_status")
    private String employee_marital_status;

    @Column(name = "employee_curp")
    private String employeeCurp;

    @Column(name = "employee_rfc")
    private String employeeRfc;

    @Column(name = "employee_nss")
    private String employeeNss;

    @Column(name = "employee_phone")
    private String employeePhone;

    @Column(name = "employee_created_at")
    private Date employeeCreatedAt;

    @Column(name = "employee_modified_at")
    private Date employeeModifiedAt;

    @Column(name = "employee_is_active")
    private Boolean employeeIsActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    @JsonManagedReference
    private AreaModel area;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_roles", // tabla intermedia
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonManagedReference
    private List<RoleModel> roles;

}
