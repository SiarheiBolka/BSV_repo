package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTransportException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.ArrayList;
import java.util.List;

public class Finder {

    //private static String EMPLOYEE_INFO_TXT = "catalog.txt";

    public static List<BaseTour> FindTours(String[] paramaters) {


        List<BaseTour> list = Runner.reader.readAll(ServiceSelector.EMPLOYEE_INFO_TXT);
        List<BaseTour> resultToursList = new ArrayList<>();

        try {
            list = findByDescType(list, paramaters[0]);
        } catch (FindByTypeException e) {
            System.out.println(e.getMessage());
            return resultToursList;
        }
        try {
            list = findByFood(list, paramaters[1]);
        } catch (FindByFoodException e) {
            System.out.println(e.getMessage());
            return resultToursList;
        }
        try {
            list = findByTransport(list, paramaters[2]);
        } catch (FindByTransportException e) {
            System.out.println(e.getMessage());
            return resultToursList;
        }
        try {
            list = findByPrice(list, paramaters[3]);
        } catch (FindByPriceException e) {
            System.out.println(e.getMessage());
            return resultToursList;
        }
        return list;
    }

    //Searching by DescType
    public static List<BaseTour> findByDescType(List<BaseTour> list, String searchValue) throws FindByTypeException {

        List<BaseTour> resultList = new ArrayList<BaseTour>();

        if (searchValue.isEmpty()){
            return list;
        } else {
            for (BaseTour tour : list) {
                if(searchValue.equals(tour.getTypeDesc())){
                    resultList.add(tour);
                }
            }
        if (resultList.size() == 0) {
            throw new FindByTypeException(searchValue);
        }
            return resultList;
        }
    }

    //Searching by Food
    public static List<BaseTour> findByFood(List<BaseTour> list, String searchValue) throws FindByFoodException {

        List<BaseTour> resultList = new ArrayList<BaseTour>();

        if (searchValue.isEmpty()){
            return list;
        } else {
            for (BaseTour tour : list) {
                if (searchValue.equals(tour.getFood())) {
                    resultList.add(tour);
                }
            }
            if (resultList.size() == 0) {
                throw new FindByFoodException(searchValue);
            }
            return resultList;
        }
    }

    //Searching by Transport
    public static List<BaseTour> findByTransport(List<BaseTour> list, String searchValue) throws FindByTransportException {

        List<BaseTour> resultList = new ArrayList<BaseTour>();

        if (searchValue.isEmpty()){
            return list;
        } else {
            for (BaseTour tour : list) {
                if (searchValue.equals(tour.getTransport())) {
                    resultList.add(tour);
                }
            }
            if (resultList.size() == 0) {
                throw new FindByTransportException(searchValue);
            }
            return resultList;
        }
    }

     //Searching by Price
     public static List<BaseTour> findByPrice(List<BaseTour> list, String searchValue) throws FindByPriceException {

        List<BaseTour> resultList = new ArrayList<BaseTour>();

         if (searchValue.isEmpty()){
             return list;
         } else {
             for (BaseTour tour : list) {
                 if (Double.parseDouble(searchValue) == tour.getPrice()) {
                     resultList.add(tour);
                 }
             }
            if (resultList.size() == 0) {
                throw new FindByPriceException(searchValue);
            }
             return resultList;
         }
     }
}
