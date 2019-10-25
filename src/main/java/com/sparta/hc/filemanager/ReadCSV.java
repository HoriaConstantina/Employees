package com.sparta.hc.filemanager;

import com.sparta.hc.employees.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReadCSV {
    private final String PATH = "resources/EmployeeRecords.csv";
    String[] employees;
//    HashMap<Employee, Employee> currentEmployees;
    public void ReadCSV() {

        Employee employeeID = new Employee();
        BufferedReader bufferedReader;
        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));

            while ((line = bufferedReader.readLine()) != null) {
                employees = line.split(",");

                System.out.println(Arrays.toString(employees));
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
