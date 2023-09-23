package com.baeldung.application;

import com.baeldung.application.entities.Employee;
import com.baeldung.application.repositories.EmployeeRepository;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Employee emp = new Employee(name, name.toLowerCase() + "@domain.com");
                employeeRepository.save(emp);
            });
            employeeRepository.findAll().forEach(System.out::println);
        };
    }
}
