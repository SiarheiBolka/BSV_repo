package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.List;
import java.util.Scanner;

public class ServiceSelector {

    private boolean repeat = true;

    public void selectAction(Scanner scanner) {

        while (repeat) {
            System.out.println("Menu");
            System.out.println("0 - Back");
            System.out.println("1 - Print tours");
            System.out.println("2 - Find tours");
            System.out.println("3 - Sort tours");
            System.out.println("4 - Add tours");
            System.out.println("5 - Delete tours");

            Printer printer = new ListPrinter();
            int action;
            action = scanner.nextInt();

            switch (action) {

                case 0:
                    repeat = false;
                    break;

                case 1:

                    printer.print(Runner.getList());
                    break;

                case 2:
                    String[] paramaters = new SearchParameterSelector().chooseParameter(scanner);
                    new Utils().FindTours(paramaters);
                    printer.print(Utils.getToursListAfterSearch());
                    break;

                case 3:
                    //new Sorter().SortBy();
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    break;
            }
        }
    }
}