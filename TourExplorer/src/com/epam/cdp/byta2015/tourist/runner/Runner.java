package com.epam.cdp.byta2015.tourist.runner;

import com.epam.cdp.byta2015.tourist.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.tourist.datareaders.Reader;
import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.datareaders.XmlFileReader;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.services.ServiceSelector;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private static List<BaseTour> list = new ArrayList<BaseTour>();
    public static Reader reader;

    public static void main(String[] args) throws FindByTypeException {

        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);

        while (repeat) {
            System.out.println("Menu");
            System.out.println("0 - Exit");
            System.out.println("1 - Load data from .txt file");
            System.out.println("2 - Load data from DB");
            System.out.println("3 - Load data from .xml file");

            int action;

            action = scanner.nextInt();

            switch (action) {

                case 0:
                    repeat = false;
                    System.out.println("Completed!");
                    scanner.close();
                    try {
                        if (DatabaseReader.c != null)
                            DatabaseReader.c.close();
                    } catch (SQLException e) {
                    }
                    break;

                case 1:
                    list.clear();
                    reader = new TxtFileReader();
                    setList(reader.readAll());
                    new ServiceSelector().selectAction(scanner);
                    break;

                case 2:
                    list.clear();
                    reader = new DatabaseReader();
                    setList(reader.readAll());
                    new ServiceSelector().selectAction(scanner);
                    break;

                case 3:
                    list.clear();
                    reader = new XmlFileReader();
                    setList(reader.readAll());
                    new ServiceSelector().selectAction(scanner);

                default:
                    break;
            }
        }
    }

    public static List<BaseTour> getList() {
        return list;
    }

    public static void setList(List<BaseTour> list) {
        Runner.list = list;
    }
}