package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.ArrayList;
import java.util.List;

public class FinderByPrice {

    private static List<BaseTour> findByPriceList = new ArrayList<BaseTour>();

    public List<BaseTour> findBy(String searchValue) throws FindByPriceException {

       int counter = 0;

        for (BaseTour tour : Runner.getList()) {
            if(searchValue.equals(tour.getPrice().toString())){
                findByPriceList.add(tour);
                counter ++;
            }
        }
        if (counter == 0) {
            throw new FindByPriceException(searchValue);
            //System.out.println("No tours with " + searchValue + " price!");
        }

        return findByPriceList;
    }

    public static void setFindByFoodList(List<BaseTour> findByFoodList) {
        FinderByPrice.findByPriceList = findByFoodList;
    }

    public static List<BaseTour> getFindByFoodList() {
        return findByPriceList;
    }

}
