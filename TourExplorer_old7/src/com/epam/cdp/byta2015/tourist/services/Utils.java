package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTransportException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.ArrayList;
import java.util.List;


public class Utils {

    private static List<BaseTour> toursListAfterSearch = Runner.getList();

    public void FindTours(String[] paramaters) {

        try {
            setToursListAfterSearch(findByDescType(paramaters[0]));
        } catch (FindByTypeException e) {
            e.printStackTrace();
        }
        try {
            setToursListAfterSearch(findByFood(paramaters[1]));
        } catch (FindByFoodException e) {
            e.printStackTrace();
        }
        try {
            setToursListAfterSearch(findByTransport(paramaters[2]));
        } catch (FindByTransportException e) {
            e.printStackTrace();
        }
        try {
            setToursListAfterSearch(findByPrice(paramaters[3]));
        } catch (FindByPriceException e) {
            e.printStackTrace();
        }
        System.out.println("Searching finished!\n");
    }

    //Searching by DescType
    public List<BaseTour> findByDescType(String searchValue) throws FindByTypeException {

        List<BaseTour> toursListAfterSearchByDescType = new ArrayList<BaseTour>();
        int counter = 0;

        if (searchValue ==""){
            return toursListAfterSearch;
        } else {
            for (BaseTour tour : toursListAfterSearch) {

                if(searchValue.equals(tour.getTypeDesc())){
                    toursListAfterSearchByDescType.add(tour);
                    counter++;
                }
            }
        if (counter == 0) {
            throw new FindByTypeException(searchValue);
        }
            return toursListAfterSearchByDescType;
        }
    }

    //Searching by Food
    public List<BaseTour> findByFood(String searchValue) throws FindByFoodException {

        List<BaseTour> toursListAfterSearchByFood = new ArrayList<BaseTour>();
        int counter = 0;

        if (searchValue ==""){
            return getToursListAfterSearch();
        } else {
            for (BaseTour tour : toursListAfterSearch) {
                if (searchValue.equals(tour.getFood())) {
                    toursListAfterSearchByFood.add(tour);
                    counter++;
                }
            }
            if (counter == 0) {
                throw new FindByFoodException(searchValue);
            }
            return toursListAfterSearchByFood;
        }
    }

    //Searching by Transport
    public List<BaseTour> findByTransport(String searchValue) throws FindByTransportException {

        List<BaseTour> toursListAfterSearchByTransport = new ArrayList<BaseTour>();
        int counter = 0;

        if (searchValue ==""){
            return getToursListAfterSearch();
        } else {
            for (BaseTour tour : toursListAfterSearch) {
                if (searchValue.equals(tour.getTransport())) {
                    toursListAfterSearchByTransport.add(tour);
                    counter++;
                }
            }
            if (counter == 0) {
                throw new FindByTransportException(searchValue);
            }
            return toursListAfterSearchByTransport;
        }
    }

     //Searching by Price
     public List<BaseTour> findByPrice(String searchValue) throws FindByPriceException {

        List<BaseTour> toursListAfterSearchByPrice = new ArrayList<BaseTour>();
         int counter = 0;

         if (searchValue ==""){
             return getToursListAfterSearch();
         } else {
             for (BaseTour tour : toursListAfterSearch) {
                 if (Double.parseDouble(searchValue) == tour.getPrice()) {
                     toursListAfterSearchByPrice.add(tour);
                     counter++;
                 }
             }
            if (counter == 0) {
                throw new FindByPriceException(searchValue);
            }
             return toursListAfterSearchByPrice;
         }
     }

    public static List<BaseTour> getToursListAfterSearch() {
        return toursListAfterSearch;
    }

    public void setToursListAfterSearch(List<BaseTour> toursListAfterSearch) {
        this.toursListAfterSearch = toursListAfterSearch;
    }

}
