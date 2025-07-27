package com.zaeta.core.areas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

}
