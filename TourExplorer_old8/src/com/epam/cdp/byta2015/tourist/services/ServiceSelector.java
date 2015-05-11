package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.datareaders.ConsoleReader;
import com.epam.cdp.byta2015.tourist.dataremovers.RemoverFromDatabase;
import com.epam.cdp.byta2015.tourist.datawriters.DatabaseWriter;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ServiceSelector {

    //private Remover remover;
    private boolean repeat = true;
    Scanner scanner = new Scanner(System.in);
    Printer pr = new ListPrinter();

    int action = 0;

    public void selectAction() {

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

                    pr.print(Runner.getList());
                    break;

                case 2:
                    String[] paramaters = new SearchParameterSelector().chooseParameter();
                    new Utils().FindTours(paramaters);
                    pr.print(Utils.getToursListAfterSearch());
                    break;

                case 3:
                    Sorter.selectSortValue();
                    pr.print(new Sorter().Sort());
                    break;

                case 4:
                    new DatabaseWriter().addNewTour(ConsoleReader.selectTourForAdding());
                    break;

                case 5:
                    new RemoverFromDatabase().removeTour(ConsoleReader.selectTourForDeletion());
                    break;

                default:
                    break;
            }

        }
    }
}