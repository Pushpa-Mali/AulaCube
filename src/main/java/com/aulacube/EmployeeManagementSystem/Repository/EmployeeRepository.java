package com.aulacube.EmployeeManagementSystem.Repository;

import com.aulacube.EmployeeManagementSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
