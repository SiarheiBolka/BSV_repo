package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.ArrayList;
import java.util.List;


public class Utils {

    private static List<BaseTour> toursListAfterSearch = Runner.getList();

    public void FindTours(String[] paramaters) {

        setToursListAfterSearch(findByDescType(paramaters[0]));
        setToursListAfterSearch(findByFood(paramaters[1]));
        setToursListAfterSearch(findByTransport(paramaters[2]));
        setToursListAfterSearch(findByPrice(paramaters[3]));
    }

    //Searching by DescType
    public List<BaseTour> findByDescType(String searchValue){

        List<BaseTour> toursListAfterSearchByDescType = new ArrayList<BaseTour>();

        if (searchValue ==""){
            return toursListAfterSearch;
        } else {
            for (BaseTour tour : toursListAfterSearch) {

                if(searchValue.equals(tour.getTypeDesc())){
                    toursListAfterSearchByDescType.add(tour);
                }
            }
        /*if (counter == 0) {
            throw new FindByTypeException(searchValue);
        }*/
            return toursListAfterSearchByDescType;
        }
    }

    //Searching by Food
    public List<BaseTour> findByFood(String searchValue) {

        List<BaseTour> toursListAfterSearchByFood = new ArrayList<BaseTour>();

        if (searchValue ==""){
            return getToursListAfterSearch();
        } else {
            for (BaseTour tour : toursListAfterSearch) {
                if (searchValue.equals(tour.getFood())) {
                    toursListAfterSearchByFood.add(tour);
                }
            }
            /*if (counter == 0) {
                throw new FindByFoodException(searchValue);
            }*/
            return toursListAfterSearchByFood;
        }
    }

    //Searching by Transport
    public List<BaseTour> findByTransport(String searchValue) {

        List<BaseTour> toursListAfterSearchByTransport = new ArrayList<BaseTour>();

        if (searchValue ==""){
            return getToursListAfterSearch();
        } else {
            for (BaseTour tour : toursListAfterSearch) {
                if (searchValue.equals(tour.getTransport())) {
                    toursListAfterSearchByTransport.add(tour);
                }
            }
            /*if (counter == 0) {
                throw new FindByFoodException(searchValue);
            }*/
            return toursListAfterSearchByTransport;
        }
    }

     //Searching by Price
     public List<BaseTour> findByPrice(String searchValue) {

        List<BaseTour> toursListAfterSearchByPrice = new ArrayList<BaseTour>();

         if (searchValue ==""){
             return getToursListAfterSearch();
         } else {
             for (BaseTour tour : toursListAfterSearch) {
                 if (Double.parseDouble(searchValue) == tour.getPrice()) {
                     toursListAfterSearchByPrice.add(tour);
                 }
             }
            /*if (counter == 0) {
                throw new FindByFoodException(searchValue);
            }*/
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
