package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.List;
import java.util.Scanner;
//import com.epam.cdp.byta2015.tourist.runner.Runner;

public class SearchParameterSelector {

    private String[] searchParameters = {"typeDesc", "food", "transport", "price"};

    private String[] desctTypeValues = {"Shopping", "Cruise", "Excursion"};
    private String[] foodValues = {"No_food", "Tea", "AI", "Breakfast"};
    private String[] transportValues = {"Bus", "Train", "Plane", "Car", "Aurora", "Azura"};
    private String priceValue;

    private boolean repeat = true;

    public void chooseParameter(List<BaseTour> list, Scanner scanner) {

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

                        switch (action) {
                            case 0:
                                repeat1 = false;
                                break;
                            case 1:
                                new FinderByDescType().findBy(desctTypeValues[0], list);
                                repeat = false;
                                break;
                            case 2:
                                new FinderByDescType().findBy(desctTypeValues[1], list);
                                repeat = false;
                                break;
                            case 3:
                                new FinderByDescType().findBy(desctTypeValues[2], list);
                                repeat = false;
                                break;
                            default:
                                break;
                        }
                    }

                    break;

                case 2:

                    boolean repeat2 = true;
                    System.out.println("Select search value: ");

                    while (repeat2) {
                        System.out.println("0 - Back");
                        System.out.println("1 - " + foodValues[0]);
                        System.out.println("2 - " + foodValues[1]);
                        System.out.println("3 - " + foodValues[2]);

                        action = scanner.nextInt();

                        switch (action) {
                            case 0:
                                repeat2 = false;
                                break;
                            case 1:
                                new FinderByFood().findBy(foodValues[0], list);
                                repeat2 = false;
                                break;
                            case 2:
                                new FinderByFood().findBy(foodValues[1], list);
                                repeat2 = false;
                                break;
                            case 3:
                                new FinderByFood().findBy(foodValues[2], list);
                                repeat2 = false;
                                break;
                            default:
                                break;
                        }
                    }

                  break;

                case 3:

                    boolean repeat3 = true;
                    System.out.println("Select search value: ");

                    while (repeat3) {
                        System.out.println("0 - Back");
                        System.out.println("1 - " + transportValues[0]);
                        System.out.println("2 - " + transportValues[1]);
                        System.out.println("3 - " + transportValues[2]);

                        action = scanner.nextInt();

                        switch (action) {
                            case 0:
                                repeat3 = false;
                                break;
                            case 1:
                                new FinderByTransport().findBy(transportValues[0], list);
                                repeat3 = false;
                                break;
                            case 2:
                                new FinderByTransport().findBy(transportValues[1], list);
                                repeat3 = false;
                                break;
                            case 3:
                                new FinderByTransport().findBy(transportValues[2], list);
                                repeat3 = false;
                                break;
                            case 4:
                                new FinderByTransport().findBy(transportValues[3], list);
                                repeat3 = false;
                                break;
                            case 5:
                                new FinderByTransport().findBy(transportValues[4], list);
                                repeat3 = false;
                                break;
                            case 6:
                                new FinderByTransport().findBy(transportValues[5], list);
                                repeat3 = false;
                                break;
                            default:
                                break;
                        }
                    }

                   break;

                case 4:

                    boolean repeat4 = true;
                    System.out.println("Select search value: ");

                    while (repeat4) {
                        System.out.println("0 - Back");
                        System.out.println("1 - Enter required price");

                        action = scanner.nextInt();
                        //System.out.println("Your price: ");
                        //priceValue = scanner.nextLine();
                        priceValue = "12.00";

                        switch (action) {
                            case 0:
                                repeat4 = false;
                                break;
                            case 1:
                                try {
                                    new FinderByPrice().findBy(priceValue, list);
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
