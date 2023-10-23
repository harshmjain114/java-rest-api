package com.perfictglobal.employeemanagementapi;

import com.perfictglobal.employeemanagementapi.model.Employee;
import com.perfictglobal.employeemanagementapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApiApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Harsh");
		employee.setLastName("Jain");
		employee.setEmailId("harsh@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Jatin");
		employee1.setLastName("Kumar");
		employee1.setEmailId("jatin@gmail.com");
		employeeRepository.save(employee1);
	}
}
