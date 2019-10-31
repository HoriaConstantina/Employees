package com.sparta.hc.filemanager;

import com.sparta.hc.employees.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeManager {
    private final String PATH = "resources/EmployeeRecords.csv";
    private Map<String, Employee> record = new HashMap<>();



    public Map<String, Employee> csvReader() {

        BufferedReader bufferedReader;
        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            bufferedReader.readLine();
            line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] employees = line.split(",");

                record.put(employees[0], new Employee(employees));
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return record;
    }


    public void csvReaderTest() {

//        BufferedReader bufferedReader;
//        String line = "";

        List<String> employeeList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(PATH))){
            employeeList = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        employeeList.forEach(System.out::println);


//        try {
//            bufferedReader = new BufferedReader(new FileReader(PATH));
//            bufferedReader.readLine();
//            line = bufferedReader.readLine();
//
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] employees = line.split(",");
//                record.put(employees[0], new Employee(employees));
//            }
//            bufferedReader.close()
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public Map<String, Employee> getRecords(){
        return record;
    }

}
