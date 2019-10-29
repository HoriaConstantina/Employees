package com.sparta.hc.filemanager;

import com.sparta.hc.employees.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class EmployeeManager {
    private final String PATH = "resources/EmployeeRecords.csv";
    HashMap<String, Employee> record = new HashMap<>();



    public void ReadCSV() {

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
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }



}