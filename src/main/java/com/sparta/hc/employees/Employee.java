package com.sparta.hc.employees;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private int salary;
    private String employeeID;
    private String namePrefix;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");


    public Employee(String[] employee) {
        for (int i = 1; i < employee.length; i++){
            setEmployeeID(employee[0]);
            setNamePrefix(employee[1]);
            setFirstName(employee[2]);
            setMiddleInitial(employee[3]);
            setLastName(employee[4]);
            setGender(employee[5]);
            setEmail(employee[6]);
            setDateOfBirth(LocalDate.parse(employee[7], dateTimeFormatter));
            setDateOfJoining(LocalDate.parse(employee[8], dateTimeFormatter));
            setSalary(Integer.parseInt(employee[9]));
        }
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

}
