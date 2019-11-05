package com.sparta.hc.database;

import com.sparta.hc.employees.Employee;

import java.sql.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class DAO {
    private final String QUERY = "select firstName, lastName from employee_table where emp_id=?";
    private final String URL = "jdbc:mysql://localhost/employee?user=root&password=Asdfghjkl123456";
    private final String INSERT = "insert into employee_table values (?,?,?,?,?,?,?,?,?,?)";

    public void insertValues(Map<String,Employee> employeeMap) {
        try(Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement statement = connection.prepareStatement(INSERT);

            for (Employee employee : employeeMap.values()){
                statement.setString(1, employee.getEmployeeID());
                statement.setString(2, employee.getNamePrefix());
                statement.setString(3, employee.getFirstName());
                statement.setString(4, employee.getMiddleInitial());
                statement.setString(5, employee.getLastName());
                statement.setString(6, employee.getGender());
                statement.setString(7, employee.getEmail());
                statement.setDate(8, Date.valueOf(employee.getDateOfBirth()));
                statement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
                statement.setString(10, String.valueOf(employee.getSalary()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
