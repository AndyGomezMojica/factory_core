package com.zaeta.core.areas.model.repository;

import com.zaeta.core.areas.model.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<AreaModel, Long> {

    Boolean existsByAreaName(String areaName);
}
