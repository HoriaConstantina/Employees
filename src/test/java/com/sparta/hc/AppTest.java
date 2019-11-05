package com.sparta.hc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.sparta.hc.database.DAO;
import com.sparta.hc.employees.Employee;
import com.sparta.hc.filemanager.EmployeeManager;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private EmployeeManager employeeManager;
    private Employee employee;
    private List employeeList;
    private Iterator spliterator;
    private List newEmployeeList;

    @Before
    public void setUp(){

        employeeManager = new EmployeeManager();
        employeeList = (List) employeeManager.csvReader();
        spliterator = employeeList.iterator();
        newEmployeeList.add(spliterator);

    }

    @Test
    public void testRecordsLength() {
        employeeManager.csvReader();
        System.out.println(employeeManager.getRecords().size());
    }

    @Test
    public void testIDs() {
        employeeManager.csvReader();
    }

    @Test
    public void testNames(){
        System.out.println(newEmployeeList.get(2));

    }
}
