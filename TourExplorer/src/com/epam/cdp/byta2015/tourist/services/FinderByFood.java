package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.ArrayList;
import java.util.List;

public class FinderByFood {



    private static List<BaseTour> findByFoodList = new ArrayList<BaseTour>();

    public List<BaseTour> findBy(String searchValue) {

        int counter = 0;

        for (BaseTour tour : Runner.getList()) {
            if(searchValue.equals(tour.getFood())){
                findByFoodList.add(tour);
                counter ++;
            }
        }
        /*if (counter == 0) {
            throw new FindByFoodException(searchValue);
        }*/
        return findByFoodList;
    }

    public static List<BaseTour> getFindByFoodList() {
        return findByFoodList;
    }

    public static void setFindByFoodList(List<BaseTour> findByFoodList) {
        FinderByFood.findByFoodList = findByFoodList;
    }

}
