package com.zaeta.core.roles.model.repository;

import com.zaeta.core.roles.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    Boolean existsByRoleName(String roleName);
    List<RoleModel> findByRoleIsActive(Boolean isActive);
}
