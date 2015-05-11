package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class SearchParameterSelector {

    private boolean repeat = true;

    public String[] chooseParameter() {

        String[] searchParametersValues = new String[4];

        System.out.println("Select search parameter: ");

        while (repeat) {
            System.out.println("0 - Back");
            System.out.println("1 - Select values for searching");

            int action;
            Scanner scanner = new Scanner(System.in);
            action = scanner.nextInt();

            switch (action) {

                case 0:
                    repeat = false;
                    break;

                case 1:

                    boolean repeat1 = true;
                    System.out.println("Select a typeDesc value: ");

                    while (repeat1) {

                        System.out.println("0 - Blank");
                        for (int i = 0; i < BaseTour.getDesctTypeValues().length; i++) {
                            System.out.println((i + 1) + " - " + BaseTour.getDesctTypeValues()[i]);
                        }

                        action = scanner.nextInt();

                        if (action == 0) {
                            searchParametersValues[0] = "";
                        } else {
                            searchParametersValues[0] = BaseTour.getDesctTypeValues()[action - 1];
                        }

                        System.out.println("Select a food value: ");
                        System.out.println("0 - Blank");
                        for (int i = 0; i < BaseTour.getFoodValues().length; i++) {
                            System.out.println((i + 1) + " - " + BaseTour.getFoodValues()[i]);
                        }

                        action = scanner.nextInt();

                        if (action == 0) {
                            searchParametersValues[1] = "";
                        } else {
                            searchParametersValues[1] = BaseTour.getFoodValues()[action - 1];
                        }

                        System.out.println("Select a transport value: ");
                        System.out.println("0 - Blank");
                        for (int i = 0; i < BaseTour.getTransportValues().length; i++) {
                            System.out.println((i + 1) + " - " + BaseTour.getTransportValues()[i]);
                        }

                        action = scanner.nextInt();

                        if (action == 0) {
                            searchParametersValues[2] = "";
                        } else {
                            searchParametersValues[2] = BaseTour.getTransportValues()[action - 1];
                        }

                        System.out.println("Select a price value: ");
                        System.out.println("0 - Blank");
                        System.out.println("1 - Enter required price");

                        action = scanner.nextInt();

                        if (action == 0) {
                            searchParametersValues[3] = "";
                        } else if (action == 1) {
                            System.out.println("Type you price:");
                            double priceValue = (double) scanner.nextInt();
                            searchParametersValues[3] = String.valueOf(priceValue);
                        } else {
                            System.out.println("Incorrect value entered");
                        }
                        repeat1 = false;
                    }

                    break;
            }
            repeat = false;
        }
        return searchParametersValues;
    }


}
