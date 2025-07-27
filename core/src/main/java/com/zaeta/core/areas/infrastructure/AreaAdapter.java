package com.zaeta.core.areas.infrastructure;

import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.web.responses.input.CreateAreaInput;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AreaAdapter {

    public AreaModel inputAreaToModel(CreateAreaInput input){
        return AreaModel.builder()
                .areaName(input.getAreaName().toUpperCase())
                .areaDescription(input.getAreaDescription())
                .areaCreatedAt(new Date())
                .areaIsActive(true)
                .build();
    }

}
