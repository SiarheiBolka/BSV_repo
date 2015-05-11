package com.epam.cdp.byta2015.tourist.runner;

import com.epam.cdp.byta2015.tourist.datareaders.DatabaseWorker;
import com.epam.cdp.byta2015.tourist.datareaders.Reader;
import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.datareaders.XmlFileReader;
import com.epam.cdp.byta2015.tourist.dataremovers.Remover;
import com.epam.cdp.byta2015.tourist.datawriters.TxtFileWriter;
import com.epam.cdp.byta2015.tourist.datawriters.Writer;
import com.epam.cdp.byta2015.tourist.datawriters.XmlFileWriter;
import com.epam.cdp.byta2015.tourist.services.ServiceSelector;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

    public static Reader reader;
    public static Writer writer;
    public static Remover remover;
    private static final String EMPLOYEE_INFO_TXT = "catalog.txt";

    public static void main(String[] args) {

        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);

        while (repeat) {
            System.out.println("Menu");
            System.out.println("0 - Exit");
            System.out.println("1 - Load data from .txt file");
            System.out.println("2 - Load data from DB");
            System.out.println("3 - Load data from .xml file");

            int action;

            try {
                action = scanner.nextInt();

                switch (action) {

                    case 0:
                        repeat = false;
                        System.out.println("Completed!");
                        scanner.close();
                        DatabaseWorker.closeConnection();
                        break;

                    case 1:
                        reader = new TxtFileReader(EMPLOYEE_INFO_TXT);
                        writer = new TxtFileWriter();
                        //remover = new RemoverFromTxtFile();
                        new ServiceSelector().selectAction();
                        break;

                    case 2:
                        reader = new DatabaseWorker();
                        writer = new DatabaseWorker();
                        remover = new DatabaseWorker();
                        new ServiceSelector().selectAction();
                        break;

                    case 3:
                        reader = new XmlFileReader();
                        writer = new XmlFileWriter();
                        //remover = new RemoverFromXmlFile();
                        new ServiceSelector().selectAction();
                        break;

                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                e.getMessage();
                break;
            }
        }
    }

}