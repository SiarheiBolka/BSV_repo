package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.com.epam.cdp.byta2015.Services.ListPrinter;
import com.epam.cdp.byta2015.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.List;
import java.util.Scanner;

public class ServiceSelector {

    private boolean repeat = true;

    public void selectAction(List<BaseTour> list, Scanner scanner) {

        while (repeat) {
            System.out.println("Menu");
            System.out.println("0 - Back");
            System.out.println("1 - Print tours");
            System.out.println("2 - Find tours");
            System.out.println("3 - Sort tours");

            int action;
            action = scanner.nextInt();

            switch (action) {

                case 0:
                    repeat = false;
                    break;

                case 1:
                    new ListPrinter().print(list);
                    break;

                case 2:
                    new SearchParameterSelector().chooseParameter(list, scanner);
                    break;

                case 3:
                    //new Sorter().SortBy();
                    break;

                default:
                    break;
            }
        }
    }
}