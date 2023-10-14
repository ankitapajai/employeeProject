package com.bootcoding.employeeProject.model;

import lombok.Data;

@Data
public class Employee {
    private int emp_id;
    private String emp_name;
    private long emp_phone;
    private String emp_mail;
    private String emp_address;
}
