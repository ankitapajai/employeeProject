package com.bootcoding.employeeProject.service;

import com.bootcoding.employeeProject.model.Employee;
import com.bootcoding.employeeProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }

    public String createEmployee(Employee employee) {
        print(employee);
        employeeRepository.save(employee);
        return "Successfully Employee Created! ";
    }

    private void print(Employee employee){
        System.out.println(employee.getEmp_id());
        System.out.println(employee.getEmp_name());
        System.out.println(employee.getEmp_phone());
        System.out.println(employee.getEmp_mail());
        System.out.println(employee.getEmp_address());
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    public String deleteEmployee(int emp_id, Employee employee) {
        return employeeRepository.deleteEmployee(emp_id);
    }
}

