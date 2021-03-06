package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.*;

public class Sorter {

    public static List<BaseTour> sort(List<BaseTour> sortedList, int sortParameter) {

        //List<BaseTour> sortedList = Runner.reader.readAll();

        switch (sortParameter){
            case 0:
                break;
            case 1:
                Collections.sort(sortedList, COMPARE_BY_DESC_TYPE);
                break;
            case 2:
                Collections.sort(sortedList, COMPARE_BY_FOOD);
                break;
            case 3:
                Collections.sort(sortedList, COMPARE_BY_TRANSPORT);
                break;
            case 4:
                Collections.sort(sortedList, COMPARE_BY_PRICE);
                break;
            default:
                break;
        }
        return sortedList;
    }

    public static int selectSortValue() {

        System.out.println("Select sort value: ");
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        int sortParam = 0;

        while (repeat) {
            System.out.println("0 - Back");
            System.out.println("1 - Sort by DescType");
            System.out.println("2 - Sort by Food");
            System.out.println("3 - Sort by Transport");
            System.out.println("4 - Sort by Price");

            sortParam = scanner.nextInt();
            repeat = false;
        }
        return sortParam;
    }

    public static Comparator<BaseTour> COMPARE_BY_DESC_TYPE = new Comparator<BaseTour>() {

        public int compare(BaseTour one, BaseTour other) {
            return one.getTypeDesc().compareTo(other.getTypeDesc());
        }
    };

    public static Comparator<BaseTour> COMPARE_BY_FOOD = new Comparator<BaseTour>() {
        public int compare(BaseTour one, BaseTour other) {
            return one.getFood().compareTo(other.getFood());
        }
    };

    public static Comparator<BaseTour> COMPARE_BY_TRANSPORT = new Comparator<BaseTour>() {
        public int compare(BaseTour one, BaseTour other) {
            return one.getTransport().compareTo(other.getTransport());
        }
    };

    public static Comparator<BaseTour> COMPARE_BY_PRICE = new Comparator<BaseTour>() {
        public int compare(BaseTour one, BaseTour other) {
            return one.getPrice().compareTo(other.getPrice());
        }
    };

}
