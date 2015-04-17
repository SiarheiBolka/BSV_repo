package com.epam.cdp.byta2015.tourist.runner;

import com.epam.cdp.byta2015.tourist.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.tourist.datareaders.Reader;
import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.datareaders.XmlFileReader;
import com.epam.cdp.byta2015.tourist.dataremovers.Remover;
import com.epam.cdp.byta2015.tourist.dataremovers.RemoverFromDatabase;
import com.epam.cdp.byta2015.tourist.datawriters.DatabaseWriter;
import com.epam.cdp.byta2015.tourist.datawriters.TxtFileWriter;
import com.epam.cdp.byta2015.tourist.datawriters.Writer;
import com.epam.cdp.byta2015.tourist.datawriters.XmlFileWriter;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.services.ServiceSelector;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {


    public static Reader reader;
    public static Writer writer;
    public static Remover remover;


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
                    DatabaseReader.closeConnection(DatabaseReader.DatabaseReader());
                    break;

                case 1:
                    reader = new TxtFileReader();
                    writer = new TxtFileWriter();
                    //remover = new RemoverFromTxtFile();
                    new ServiceSelector().selectAction();
                    break;

                case 2:
                    reader = new DatabaseReader();
                    writer = new DatabaseWriter();
                    remover = new RemoverFromDatabase();
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
        }
    }

    public static List<BaseTour> getList() {
        return reader.readAll();
    }

    public static Reader getReader() {
        return reader;
    }

}