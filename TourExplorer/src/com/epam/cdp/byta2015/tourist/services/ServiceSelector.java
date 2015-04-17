package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.datareaders.ConsoleReader;
import com.epam.cdp.byta2015.tourist.datareaders.DatabaseWorker;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ServiceSelector {

    private boolean repeat = true;
    Scanner scanner = new Scanner(System.in);
    Printer pr = new ListPrinter();

    int action=0;

    public void selectAction( ) {

        while (repeat) {
            System.out.println("Menu");
            System.out.println("0 - Back");
            System.out.println("1 - Print tours");
            System.out.println("2 - Find tours");
            System.out.println("3 - Sort tours");
            System.out.println("4 - Add tour");
            System.out.println("5 - Delete tour");

            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Incorrect value entered.\n");
                break;
            }

            switch (action) {

                case 0:
                    repeat = false;
                    break;

                case 1:

                    pr.print(Runner.reader.readAll());
                    break;

                case 2:
                    String[] paramaters = new SearchParameterSelector().chooseParameter();
                    pr.print(new Finder().FindTours(paramaters));
                    break;

                case 3:
                    new Sorter().sort();
                    break;

                case 4:
                    Runner.writer.addNewTour(ConsoleReader.selectTourForAdding());
                    break;

                case 5:
                    new Runner().remover.removeTour(ConsoleReader.selectTourForDeletion());
                    break;

                default:
                    break;
            }

        }
    }
}