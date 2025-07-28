package com.zaeta.core.areas.infrastructure;

import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.web.responses.input.CreateAreaInput;
import com.zaeta.core.areas.web.responses.input.ModifiedAreaInput;
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

    public AreaModel modifiedInputToModel(AreaModel existentArea, ModifiedAreaInput input) {

        existentArea.setAreaName(input.getAreaName().toUpperCase());
        existentArea.setAreaDescription(input.getAreaDescription());
        existentArea.setAreaIsActive(input.getAreaIsActive());
        existentArea.setAreaModifiedAt(new Date());

        return existentArea;
    }
}
