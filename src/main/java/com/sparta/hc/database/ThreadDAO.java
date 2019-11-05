package com.sparta.hc.database;

import com.sparta.hc.employees.Employee;
import com.sparta.hc.filemanager.EmployeeManager;

import java.sql.*;
import java.util.Arrays;
import java.util.Map;

public class ThreadDAO {

    private final String QUERY = "TRUNCATE TABLE employee_table";
    private final String URL = "jdbc:mysql://localhost/employee?user=root&password=Asdfghjkl123456";
    private final String INSERT = "insert into employee_table values (?,?,?,?,?,?,?,?,?,?)";
    private final int NO_OF_THREADS = 150;

    public void insertValues(Map<String, Employee> employeeMap) {

        try (Connection connection2 = DriverManager.getConnection(URL)) {
            PreparedStatement statement2 = connection2.prepareStatement(QUERY);
            statement2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Runnable runnable(Employee[] employees) {
        Runnable run = () -> {
            try (Connection connection = DriverManager.getConnection(URL)) {

                PreparedStatement statement = connection.prepareStatement(INSERT);

                for (Employee employee : employees) {

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

        };
        return run;
    }


    public void executeThreads() {
        Thread[] threadList = new Thread[NO_OF_THREADS];
        EmployeeManager employeeManager = new EmployeeManager();
        Map<String, Employee> employeeMap = employeeManager.csvReader();

        Employee[] array = employeeMap.values().toArray(new Employee[employeeMap.size()]);
        for (int i = 0; i < NO_OF_THREADS; i++){

            Employee[] employees = Arrays.copyOfRange(array, (array.length*i)/threadList.length, (array.length*(i+1))/threadList.length);
            threadList[i] = new Thread(runnable(employees));
            threadList[i].start();
        }

        for (int i = 0; i < NO_OF_THREADS; i++) {
            try {
                threadList[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

