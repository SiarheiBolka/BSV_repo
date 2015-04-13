package com.epam.cdp.byta2015.tourist.runner;

import com.epam.cdp.byta2015.tourist.com.epam.cdp.byta2015.Services.ListPrinter;
import com.epam.cdp.byta2015.tourist.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.datareaders.XmlFileReader;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

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
                    list.clear();
                    list = new DatabaseReader().readAll();
                    break;

                case 3:
                    list.clear();
                    list = new XmlFileReader().readAll();
                    /*XmlFileReader xmlReader = new XmlFileReader(TOUR_INFO_XML);
                    try{
                        list = xmlReader.readAll();
                    } catch(NullPointerException ex) {
                        System.out.println("Error during loading data from .xml file! ");
                    }

                    break;
                    */
                case 4:
                    new ListPrinter().print(list);
                    break;

                default:
                    break;
            }
        }
    }
}