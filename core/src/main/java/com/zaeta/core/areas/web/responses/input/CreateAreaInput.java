package com.zaeta.core.areas.web.responses.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAreaInput {

    private String areaName;
    private String areaDescription;

}
