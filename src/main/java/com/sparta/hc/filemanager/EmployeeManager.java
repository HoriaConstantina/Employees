package com.sparta.hc.filemanager;

import com.sparta.hc.employees.Employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeManager {
    private final String PATH = "resources/EmployeeRecordsLarge.csv";
    private Map<String, Employee> record = new HashMap<>();
    private Map<String, Employee> duplicates = new HashMap<>();


    public Map<String, Employee> csvReader() {

        BufferedReader bufferedReader;
        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] employees = line.split(",");
                Employee employee = new Employee(employees);

                if (record.containsKey(employees[0])){
                    duplicates.put(employees[0], employee);
                }
                else {
                    record.put(employees[0], employee);
                }
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return record;
    }


    public Map<String, Employee> getRecords(){
        return record;
    }

}
