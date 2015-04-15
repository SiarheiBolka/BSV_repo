package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.adders.AdderToDatabase;
import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.removers.RemoverFromDatabase;
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
            System.out.println("4 - Add tour to database");
            System.out.println("5 - Delete tours from database");

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
                    Runner.setList(Utils.getToursListAfterSearch());
                    break;

                case 3:
                    Sorter.selectSortValue(scanner);
                    Runner.setList(new Sorter().Sort());
                    break;

                case 4:
                    new AdderToDatabase().addNewShopping();
                    break;

                case 5:
                    new RemoverFromDatabase().removeShoppingFromDatabase();
                    break;

                default:
                    break;
            }
        }
    }
}