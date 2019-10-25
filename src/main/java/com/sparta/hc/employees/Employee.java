package com.sparta.hc.employees;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    String firstName;
    char middleInitial;
    String lastName;
    char gender;
    String email;
    Date dateOfBirth;
    Date dateOfJoining;
    int salary;

    public Employee(){

    }

    public Employee(int employeeID){

    }

    public String getFirstName() {
        return firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }
}
