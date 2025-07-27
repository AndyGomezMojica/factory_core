package com.zaeta.core.roles.web.responses.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifiedRoleInput {

    private String roleName;
    private String roleDescription;
    private Boolean roleIsActive;
}
