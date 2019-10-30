package com.sparta.hc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.sparta.hc.database.DAO;
import com.sparta.hc.employees.Employee;
import com.sparta.hc.filemanager.EmployeeManager;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test() {
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.csvReader();
        DAO dao = new DAO();
        String[] record = new String[10];
        Employee employee = new Employee(record);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        for (int i = 1; i < record.length; i++){
            employee.setEmployeeID(record[0]);
            employee.setNamePrefix(record[1]);
            employee.setFirstName(record[2]);
            employee.setMiddleInitial(record[3]);
            employee.setLastName(record[4]);
            employee.setGender(record[5]);
            employee.setEmail(record[6]);
            employee.setDateOfBirth(LocalDate.parse(record[7], dateTimeFormatter));
            employee.setDateOfJoining(LocalDate.parse(record[8], dateTimeFormatter));
            employee.setSalary(Integer.parseInt(record[9]));
        }

        assertEquals(employee.getEmployeeID(), 198429);
    }
}
