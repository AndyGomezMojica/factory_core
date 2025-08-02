package com.zaeta.core.areas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "areas")
public class AreaModel {

    @Id
    @Column(name = "area_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;

    @Column(name = "area_name", length = 50, nullable = false)
    private String areaName;

    @Column(name = "area_description")
    private String areaDescription;

    @Column(name = "area_created_at")
    private Date areaCreatedAt;

    @Column(name = "area_modified_at")
    private Date areaModifiedAt;

    @Column(name = "area_is_active")
    private Boolean areaIsActive = true;

    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<EmployeeModel> employees;

}
