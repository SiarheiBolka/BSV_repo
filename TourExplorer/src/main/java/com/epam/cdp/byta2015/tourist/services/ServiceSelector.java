package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ServiceSelector {

    public void selectAction( ) {

        int action;
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        Printer pr = new ListPrinter();

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
                scanner = new Scanner(System.in);
                continue;
            }

            switch (action) {

                case 0:
                    repeat = false;
                    break;

                case 1:
                    pr.print(Runner.reader.readAll());
                    break;

                case 2:
                    String[] chooseParameters = SearchParameterSelector.chooseParameter();
                    List<BaseTour> findToursList = Finder.findTours(chooseParameters);
                    pr.print(findToursList);
                    break;

                case 3:
                    List<BaseTour> sortToursList = Sorter.sort(Sorter.selectSortValue());
                    pr.print(sortToursList);
                    break;

                case 4:
                    String[] tourParametersForAdd = ConsoleReader.selectTourForAdding();
                    Runner.writer.addNewTour(tourParametersForAdd);
                    break;

                case 5:
                    String[] tourParametersForDelete = ConsoleReader.selectTourForDeletion();
                    new Runner().remover.removeTour(tourParametersForDelete);
                    break;

                default:
                    break;
            }

        }
    }
}