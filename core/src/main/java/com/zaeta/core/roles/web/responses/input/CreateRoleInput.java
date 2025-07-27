package com.zaeta.core.roles.web.responses.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleInput {

    private String roleName;
    private String roleDescription;
}
