package com.perfictglobal.employeemanagementapi.repository;

import com.perfictglobal.employeemanagementapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
