package com.zaeta.core.areas.web.responses.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifiedAreaInput {

    private String areaName;
    private String areaDescription;
    private Boolean areaIsActive;

}
