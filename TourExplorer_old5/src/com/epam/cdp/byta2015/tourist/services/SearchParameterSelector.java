package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;

import java.util.Scanner;
//import com.epam.cdp.byta2015.tourist.runner.Runner;

public class SearchParameterSelector {

    private String[] searchParameters = {"typeDesc", "food", "transport", "price"};

    private String[] desctTypeValues = {"Shopping", "Cruise", "Excursion"};
    private String[] foodValues = {"No_food", "Tea", "AI", "Breakfast"};
    private String[] transportValues = {"Bus", "Train", "Plane", "Car", "Aurora", "Azura"};
    private String priceValue;

    private boolean repeat = true;

    public void chooseParameter(Scanner scanner) {

        System.out.println("Select search parameter: ");

        while (repeat) {
            System.out.println("0 - Back");
            System.out.println("1 - " + searchParameters[0]);
            System.out.println("2 - " + searchParameters[1]);
            System.out.println("3 - " + searchParameters[2]);
            System.out.println("4 - " + searchParameters[3]);

            int action;
            action = scanner.nextInt();

            switch (action) {

                case 0:
                    repeat = false;
                    break;

                case 1:

                    boolean repeat1 = true;
                    System.out.println("Select search value: ");

                    while (repeat1) {

                        System.out.println("0 - Back");
                        System.out.println("1 - " + desctTypeValues[0]);
                        System.out.println("2 - " + desctTypeValues[1]);
                        System.out.println("3 - " + desctTypeValues[2]);

                        action = scanner.nextInt();

                       if (action == 0) {
                           repeat1 = false;
                       } else {
                           new ListPrinter().print(new FinderByDescType().findBy(desctTypeValues[action - 1]));
                           repeat = false;
                       }
                    }

                case 2:

                    boolean repeat2 = true;
                    System.out.println("Select search value: ");

                    while (repeat2) {
                        System.out.println("0 - Back");
                        System.out.println("1 - " + foodValues[0]);
                        System.out.println("2 - " + foodValues[1]);
                        System.out.println("3 - " + foodValues[2]);

                        action = scanner.nextInt();

                        if (action == 0) {
                            repeat2 = false;
                        } else {
                            new ListPrinter().print(new FinderByDescType().findBy(foodValues[action - 1]));
                            repeat = false;
                        }
                    }

                case 3:

                    boolean repeat3 = true;
                    System.out.println("Select search value: ");

                    while (repeat3) {
                        System.out.println("0 - Back");
                        System.out.println("1 - " + transportValues[0]);
                        System.out.println("2 - " + transportValues[1]);
                        System.out.println("3 - " + transportValues[2]);

                        action = scanner.nextInt();

                        if (action == 0) {
                            repeat2 = false;
                        } else {
                            new ListPrinter().print(new FinderByDescType().findBy(transportValues[action - 1]));
                            repeat = false;
                        }
                    }

                   break;

                case 4:

                    boolean repeat4 = true;
                    System.out.println("Select search value: ");

                    while (repeat4) {
                        System.out.println("0 - Back");
                        System.out.println("1 - Enter required price");

                        action = (scanner.nextInt());
                        priceValue = "12.00";

                        switch (action) {
                            case 0:
                                repeat4 = false;
                                break;
                            case 1:
                                try {
                                    new ListPrinter().print(new FinderByPrice().findBy(priceValue));
                                } catch (FindByPriceException e) {
                                    e.getMessage();
                                }
                                repeat4 = false;
                                break;
                            default:
                                break;
                        }
                    }

                    break;
            }
        }
    }
}
