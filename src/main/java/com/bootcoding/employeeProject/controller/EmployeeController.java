package com.bootcoding.employeeProject.controller;

import com.bootcoding.employeeProject.model.Employee;
import com.bootcoding.employeeProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee){
        //create user
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    //------delete the records in table-------
    @DeleteMapping("/employee/{emp_id}")
    public String deleteEmployee(@PathVariable int emp_id, Employee employee){
        return employeeService.deleteEmployee(emp_id, employee);
    }
}
