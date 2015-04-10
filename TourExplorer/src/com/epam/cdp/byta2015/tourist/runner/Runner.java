package com.epam.cdp.byta2015.tourist.runner;

import com.epam.cdp.byta2015.tourist.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.services.ServiceSelector;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static List<BaseTour> list = new ArrayList<BaseTour>();

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
                    break;

                case 1:
                    list.clear();
                    list = new TxtFileReader().readAll();
                    new ServiceSelector().selectAction(list, scanner);
                    break;

                case 2:
                    list.clear();
                    list = new DatabaseReader().readAll();
                    break;

                case 3:
                    list.clear();
                    //list = new XmlFileReader().readAll();
                    /*XmlFileReader xmlReader = new XmlFileReader(TOUR_INFO_XML);
                    try{
                        list = xmlReader.readAll();
                    } catch(NullPointerException ex) {
                        System.out.println("Error during loading data from .xml file! ");
                    }
                    break;
                    */

                default:
                    break;
            }
        }
    }
}