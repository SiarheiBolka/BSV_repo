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

    public List<BaseTour> FindTours(String[] paramaters) {

        List<BaseTour> list = Runner.reader.readAll();

        try {
            list = findByDescType(list, paramaters[0]);
        } catch (FindByTypeException e) {
            e.printStackTrace();
        }
        try {
            list = findByFood(list, paramaters[1]);
        } catch (FindByFoodException e) {
            e.printStackTrace();
        }
        try {
            list = findByTransport(list, paramaters[2]);
        } catch (FindByTransportException e) {
            e.printStackTrace();
        }
        try {
            list = findByPrice(list, paramaters[3]);
        } catch (FindByPriceException e) {
            e.printStackTrace();
        }
        return list;
    }

    //Searching by DescType
    private List<BaseTour> findByDescType(List<BaseTour> list, String searchValue) throws FindByTypeException {

        List<BaseTour> resultList = new ArrayList<BaseTour>();

        if (searchValue ==""){
            return list;
        } else {
            for (BaseTour tour : list) {

                if(searchValue.equals(tour.getTypeDesc())){
                    resultList.add(tour);
                }
            }
        if (resultList.isEmpty()) {
            throw new FindByTypeException(searchValue);
        }
            return resultList;
        }
    }

    //Searching by Food
    public List<BaseTour> findByFood(List<BaseTour> list, String searchValue) throws FindByFoodException {

        List<BaseTour> resultList = new ArrayList<BaseTour>();
        int counter = 0;

        if (searchValue ==""){
            return list;
        } else {
            for (BaseTour tour : list) {
                if (searchValue.equals(tour.getFood())) {
                    resultList.add(tour);
                }
            }
            if (resultList.isEmpty()) {
                throw new FindByFoodException(searchValue);
            }
            return resultList;
        }
    }

    //Searching by Transport
    public List<BaseTour> findByTransport(List<BaseTour> list, String searchValue) throws FindByTransportException {

        List<BaseTour> resultList = new ArrayList<BaseTour>();
        int counter = 0;

        if (searchValue ==""){
            return list;
        } else {
            for (BaseTour tour : list) {
                if (searchValue.equals(tour.getTransport())) {
                    resultList.add(tour);
                }
            }
            if (resultList.isEmpty()) {
                throw new FindByTransportException(searchValue);
            }
            return resultList;
        }
    }

     //Searching by Price
     public List<BaseTour> findByPrice(List<BaseTour> list, String searchValue) throws FindByPriceException {

        List<BaseTour> resultList = new ArrayList<BaseTour>();
         int counter = 0;

         if (searchValue ==""){
             return list;
         } else {
             for (BaseTour tour : list) {
                 if (Double.parseDouble(searchValue) == tour.getPrice()) {
                     resultList.add(tour);
                 }
             }
            if (resultList.isEmpty()) {
                throw new FindByPriceException(searchValue);
            }
             return resultList;
         }
     }
}
