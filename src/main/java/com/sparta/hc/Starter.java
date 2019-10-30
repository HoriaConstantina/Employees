package com.sparta.hc;

import com.sparta.hc.database.DAO;
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
        employeeManager.csvReader();

        DAO dao = new DAO();
//        dao.runSQLQuery("198429");

        dao.insertValues(employeeManager.csvReader());
    }
}
