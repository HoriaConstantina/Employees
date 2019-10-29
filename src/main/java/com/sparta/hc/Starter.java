package com.sparta.hc;

import com.sparta.hc.filemanager.EmployeeManager;

/**
 * Hello world!
 *
 */
public class Starter
{
    public static void main( String[] args )
    {

        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.ReadCSV();
    }
}
