package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Sorter {

    private static int sortParam;
    //private String[] searchParameters = {"typeDesc", "food", "transport", "price"};


    public static List<BaseTour> Sort() {

        sortParam = getSortParam();
        List<BaseTour> sortedList = new ArrayList<BaseTour>();
        sortedList = Runner.getList();

        switch (sortParam){
            case 0:
                break;
            case 1:
                Collections.sort(sortedList, BaseTour.COMPARE_BY_DESC_TYPE);
                break;
            case 2:
                Collections.sort(sortedList, BaseTour.COMPARE_BY_FOOD);
                break;
            case 3:
                Collections.sort(sortedList, BaseTour.COMPARE_BY_TRANSPORT);
                break;
            case 4:
                Collections.sort(sortedList, BaseTour.COMPARE_BY_PRICE);
                break;
            default:
                break;
        }
        System.out.println("Sorting finished!\n");
        return sortedList;
    }

    public static void selectSortValue(Scanner scanner) {

        boolean repeat = true;

        System.out.println("Select sort value: ");

        while (repeat) {
            System.out.println("0 - Back");
            System.out.println("1 - Sort by DescType");
            System.out.println("2 - Sort by Food");
            System.out.println("3 - Sort by Transport");
            System.out.println("4 - Sort by Price");

            sortParam = scanner.nextInt();

            repeat = false;
        }
    }

    public static int getSortParam() {
        return sortParam;
    }
}
