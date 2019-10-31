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

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private EmployeeManager employeeManager;

    @Before
    public void setUp(){
        employeeManager = new EmployeeManager();
    }

    @Test
    public void testRecordsLength() {
        employeeManager.csvReaderTest();
        System.out.println(employeeManager.getRecords().size());
    }

    @Test
    public void testIDs() {
        employeeManager.csvReaderTest();
    }
}
