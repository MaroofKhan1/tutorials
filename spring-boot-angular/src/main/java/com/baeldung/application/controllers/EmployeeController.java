package com.baeldung.application.controllers;

import com.baeldung.application.entities.Employee;
import com.baeldung.application.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/users")
    public List<Employee> getUsers() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }
}
