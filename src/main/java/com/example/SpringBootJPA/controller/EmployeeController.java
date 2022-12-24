package com.example.SpringBootJPA.controller;

import com.example.SpringBootJPA.models.Employee;
import com.example.SpringBootJPA.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Employee")
public class EmployeeController {
    //DI: dependency Injection
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/GetAllEmployees")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping("/GetEmployeeById/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id);
    }

    @PostMapping("/AddEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    @PutMapping("/UpdateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        Employee e = employeeRepository.findById(id).get();
        if(e != null){
            e.setUserName(employee.getUserName());
            e.setEmail(employee.getEmail());
            e.setDateOfBirth(employee.getDateOfBirth());
            e.setPassword(employee.getPassword());
            employeeRepository.save(e);
        }
        return e;
    }
    @DeleteMapping("/DeleteEmployee/{id}")
    public boolean deleteEmployee(@PathVariable int id){
        boolean exists = employeeRepository.existsById(id);
        if(exists){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
