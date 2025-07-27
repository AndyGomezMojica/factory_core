package com.zaeta.core.areas.model.repository;

import com.zaeta.core.areas.model.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<AreaModel, Long> {

    Boolean existsByAreaName(String areaName);

    List<AreaModel> findByAreaIsActive(Boolean isActive);
}
