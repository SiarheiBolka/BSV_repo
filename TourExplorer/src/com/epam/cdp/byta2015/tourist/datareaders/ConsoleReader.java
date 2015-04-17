package com.epam.cdp.byta2015.tourist.datareaders;


import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    //TODO use data from BaseTour
    private static String[] desctTypeValues = {"Shopping", "Cruise", "Excursion"};

    public static String[] selectTourForDeletion() {

        boolean repeat = true;
        String[] values = new String[2];
        Scanner scanner = new Scanner(System.in);

        while (repeat) {
            System.out.println("0 - Cancel");
            for (int i = 0; i < desctTypeValues.length; i++) {
                System.out.println((i + 1) + " - " + desctTypeValues[i]);
            }

            int action;
            action = scanner.nextInt();

            switch (action) {

                case 0:
                    repeat = false;
                    break;

                case 1:
                    values[0] = desctTypeValues[0];
                    repeat = false;
                    boolean repeat1 = true;
                    while (repeat1) {
                        System.out.println("Enter " + desctTypeValues[0] + " tour id: ");
                        values[1] = String.valueOf(scanner.nextInt());
                        repeat1 = false;
                    }
                    break;

                case 2:
                    values[0] = desctTypeValues[1];
                    repeat = false;
                    boolean repeat2 = true;
                    while (repeat2) {
                        System.out.println("Enter " + desctTypeValues[1] + "tour id: ");
                        values[1] = String.valueOf(scanner.nextInt());
                        repeat2 = false;
                    }
                    break;

                case 3:
                    values[0] = desctTypeValues[2];
                    repeat = false;
                    boolean repeat3 = true;
                    while (repeat3) {
                        System.out.println("Enter " + desctTypeValues[2] + "tour id: ");
                        values[1] = String.valueOf(scanner.nextInt());
                        repeat3 = false;
                    }
                    break;

                default:
                    break;
            }
        }

        return values;
    }

    public static String[] selectTourForAdding() {
        Scanner scanner = new Scanner(System.in);
        String[] tourParamaters = new String[8];
        boolean repeat = true;

        while (repeat) {
            System.out.println("0 - Cancel");
            for (int i = 0; i < desctTypeValues.length; i++) {
                System.out.println((i + 1) + " - " + desctTypeValues[i]);
            }

            int action = scanner.nextInt();

            switch (action) {
                case 0:
                    repeat = false;
                    break;

                case 1:
                    tourParamaters[0] = "0";
                    tourParamaters[1] = (desctTypeValues[0]);
                    System.out.println("Enter food: ");
                    tourParamaters[2] = new Scanner(System.in).nextLine();
                    System.out.println("Enter transport: ");
                    tourParamaters[3] = new Scanner(System.in).nextLine();
                    System.out.println("Enter duration: ");
                    tourParamaters[4] = new Scanner(System.in).nextLine();
                    System.out.println("Enter price: ");
                    tourParamaters[5] = new Scanner(System.in).nextLine();
                    System.out.println("Enter country: ");
                    tourParamaters[6] = new Scanner(System.in).nextLine();
                    System.out.println("Enter night transfer: ");
                    tourParamaters[7] = new Scanner(System.in).nextLine();
                    repeat = false;
                    break;

                case 2:
                    tourParamaters[0] = "0";
                    tourParamaters[1] = (desctTypeValues[0]);
                    System.out.println("Enter food: ");
                    tourParamaters[2] = new Scanner(System.in).nextLine();
                    System.out.println("Enter transport: ");
                    tourParamaters[3] = new Scanner(System.in).nextLine();
                    System.out.println("Enter duration: ");
                    tourParamaters[4] = new Scanner(System.in).nextLine();
                    System.out.println("Enter price: ");
                    tourParamaters[5] = new Scanner(System.in).nextLine();
                    System.out.println("Enter countries list with ',' delimeter: ");
                    tourParamaters[6] = new Scanner(System.in).nextLine();
                    tourParamaters[7] = "";
                    repeat = false;
                    break;

                case 3:
                    tourParamaters[0] = "0";
                    tourParamaters[1] = (desctTypeValues[0]);
                    System.out.println("Enter food: ");
                    tourParamaters[2] = new Scanner(System.in).nextLine();
                    System.out.println("Enter transport: ");
                    tourParamaters[3] = new Scanner(System.in).nextLine();
                    System.out.println("Enter duration: ");
                    tourParamaters[4] = new Scanner(System.in).nextLine();
                    System.out.println("Enter price: ");
                    tourParamaters[5] = new Scanner(System.in).nextLine();
                    System.out.println("Enter country: ");
                    tourParamaters[6] = new Scanner(System.in).nextLine();
                    System.out.println("Enter destinations list with ',' delimeter: ");
                    tourParamaters[7] = new Scanner(System.in).nextLine();
                    repeat = false;
                    break;

                default:
                    break;
            }
        }
        return tourParamaters;
    }
}
