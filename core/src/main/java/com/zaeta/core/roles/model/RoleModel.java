package com.zaeta.core.roles.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zaeta.core.employees.model.EmployeeModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleModel {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;

    @Column(name = "role_description")
    private String roleDescription;

    @Column(name = "role_created_at")
    private Date roleCreatedAt;

    @Column(name = "role_modified_at")
    private Date roleModifiedAt;

    @Column(name = "role_is_active")
    private Boolean roleIsActive = true;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private List<EmployeeModel> employees;

}
