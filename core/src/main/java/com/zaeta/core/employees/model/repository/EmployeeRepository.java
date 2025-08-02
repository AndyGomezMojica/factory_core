package com.zaeta.core.employees.model.repository;

import com.zaeta.core.employees.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    Boolean existsByEmployeeCurp(String employeeCurp);
    Boolean existsByEmployeeRfc(String employeeRfc);
    Boolean existsByEmployeeNss(String employeeNss);

    List<EmployeeModel> findByEmployeeIsActive(Boolean isActive);

}
