package com.bootcoding.employeeProject.repository;

import com.bootcoding.employeeProject.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    private Map<Integer, Employee> employeeMap = new HashMap<>();
    // -----Logic for data enter in database----------
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public EmployeeRepository(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    public void save(Employee employee) {
       try{
           String query = "Insert into employee " + "values('" + employee.getEmp_id() + "'," + "'"
                   + employee.getEmp_name() + "'," + "'" + employee.getEmp_phone() + "'," + "'"
                   + employee.getEmp_mail() + "'," + "'" + employee.getEmp_address() + "')";
           jdbcTemplate.update(query);

       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

  //-------Logic to get the data from database------
    public List<Employee> getAllEmployee() {
        try{

            String  sql = "select * from employee";
            return jdbcTemplate.query(sql, new RowMapper<Employee>() {
                @Override
                public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Employee employee = new Employee();
                    employee.setEmp_id(rs.getInt("emp_id"));
                    employee.setEmp_name(rs.getString("emp_name"));
                    employee.setEmp_phone(rs.getLong("emp_phone"));
                    employee.setEmp_mail(rs.getString("emp_mail"));
                    employee.setEmp_address(rs.getString("emp_address"));
                    return employee;
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    //------Logic for to get the data from database by "id"------
    public Employee getEmployee(int id) {
        try{

            String sql = "select * from employee where emp_id = "+id+"";
            return jdbcTemplate.queryForObject(sql, new RowMapper<Employee>() {
                @Override
                public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Employee employee = new Employee();
                    employee.setEmp_id(rs.getInt("emp_id"));
                    employee.setEmp_name(rs.getString("emp_name"));
                    employee.setEmp_phone(rs.getLong("emp_phone"));
                    employee.setEmp_mail(rs.getString("emp_mail"));
                    employee.setEmp_address(rs.getString("emp_address"));
                    return employee;
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    //-------delete records --------
    public String deleteEmployee(int emp_id) {
        employeeMap.remove(emp_id);
        return "employee delete successfully....";
    }
}
