package com.epam.cdp.byta2015.tourist.runner;

import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.model.BaseTour;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    //private static final String EMPLOYEE_INFO_TXT = "catalog.txt";

    public static void main(String[] args) {

        List<BaseTour> list = new ArrayList<BaseTour>();
        boolean repeat = true;

        while (repeat) {
            System.out.println("Menu");
            System.out.println("0 - Exit");
            System.out.println("1 - Load data from .txt file");
            System.out.println("2 - Load data from DB");
            System.out.println("3 - Load data from .xml file");
            System.out.println("4 - Print tours");
            System.out.println("5 - Find a tour");
            System.out.println("6 - Sort tours");

            int action;
            Scanner scanner = new Scanner(System.in);
            action = scanner.nextInt();

            switch (action) {

                case 0:
                    repeat = false;
                    System.out.println("Completed!");
                    break;
                case 1:
                    list.clear();
                    list = new TxtFileReader().readAll();
                    break;

                case 2:
                    /*list.clear();
                    //loading data from first db
                    try {
                        Class.forName(driverName);
                        System.out.println("OK! Driver is registered! ");
                    } catch (ClassNotFoundException e) {
                        System.out.println("Mysql JDBC driver not found");
                    }
                    Connection c1 = null;

                    try {
                        c1 = DriverManager.getConnection(databaseURL1, user, password);
                        System.out.println("Connect");
                    } catch (SQLException e) {
                        System.out.println("SQLException " + e.getMessage());
                    }

                    DatabaseReader dbReader1 = new DatabaseReader(c1);
                    try{
                        list1 = dbReader1.readInfoFromFirstDB();
                    } catch(NullPointerException ex) {
                        System.out.println("Error during loading data from DB!");
                    }

                    try {
                        if (c1 != null)
                            c1.close();
                    } catch (SQLException e) {}

                    //loading data from second db
                    try {
                        Class.forName(driverName);
                        System.out.println("OK! Driver is registered! ");
                    } catch (ClassNotFoundException e) {
                        System.out.println("Mysql JDBC driver not found");
                    }
                    Connection c2 = null;

                    try {
                        c2 = DriverManager.getConnection(databaseURL2, user, password);
                        System.out.println("Connect");
                    } catch (SQLException e) {
                        System.out.println("SQLException " + e.getMessage());
                    }

                    DatabaseReader dbReader2 = new DatabaseReader(c2);
                    try{
                        list2 = dbReader2.readInfoFromSecondDB();
                    } catch(NullPointerException ex) {
                        System.out.println("Error during loading data from DB!");
                    }

                    try {
                        if (c2 != null)
                            c2.close();
                    } catch (SQLException e) {}

                    //loading data from third db
                    try {
                        Class.forName(driverName);
                        System.out.println("OK! Driver is registered! ");
                    } catch (ClassNotFoundException e) {
                        System.out.println("Mysql JDBC driver not found");
                    }
                    Connection c3 = null;

                    try {
                        c3 = DriverManager.getConnection(databaseURL3, user, password);
                        System.out.println("Connect");
                    } catch (SQLException e) {
                        System.out.println("SQLException " + e.getMessage());
                    }

                    DatabaseReader dbReader3 = new DatabaseReader(c3);
                    try{
                        list3 = dbReader3.readInfoFromThirdDB();
                    } catch(NullPointerException ex) {
                        System.out.println("Error during loading data from DB!");
                    }

                    try {
                        if (c3 != null)
                            c3.close();
                    } catch (SQLException e) {}

                    list.addAll(list1);
                    list.addAll(list2);
                    list.addAll(list3);

                    break;*/

                case 3:

                    /*XmlFileReader xmlReader = new XmlFileReader(TOUR_INFO_XML);
                    try{
                        list = xmlReader.readAll();
                    } catch(NullPointerException ex) {
                        System.out.println("Error during loading data from .xml file! ");
                    }

                    break;
                    */
                case 4:
                    Print.printAvailableTours(list);
                    break;

                default:
                    break;
            }
        }
    }
}