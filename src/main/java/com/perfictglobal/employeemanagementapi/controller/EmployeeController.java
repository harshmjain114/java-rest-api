package com.perfictglobal.employeemanagementapi.controller;

import com.perfictglobal.employeemanagementapi.exception.ResourceNotFoundException;
import com.perfictglobal.employeemanagementapi.model.Employee;
import com.perfictglobal.employeemanagementapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("{eid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long eid) {
        Employee employee = employeeRepository.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for id: " +  eid));
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("{eid}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable long eid, @Valid @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for id: " +  eid));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{eid}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable long eid) {
        Employee employee = employeeRepository.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for id: " +  eid));
        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
