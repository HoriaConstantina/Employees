package com.sparta.hc;

import com.sparta.hc.database.DAO;
import com.sparta.hc.database.ThreadDAO;
import com.sparta.hc.filemanager.EmployeeManager;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class Starter
{
    public static void main( String[] args )
    {

        long start = System.nanoTime();
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.csvReader();


//        DAO dao = new DAO();
//        dao.runSQLQuery("198429");

//        dao.insertValues(employeeManager.getRecords());

        ThreadDAO threadDAO = new ThreadDAO();
        threadDAO.insertValues(employeeManager.getRecords());
//        threadDAO.runnable();
        threadDAO.executeThreads();
        long end = System.nanoTime();

        double elapsedTimeInSeconds = (double) (end-start)/1_000_000_000;
        System.out.println(elapsedTimeInSeconds + " seconds");
    }
}
