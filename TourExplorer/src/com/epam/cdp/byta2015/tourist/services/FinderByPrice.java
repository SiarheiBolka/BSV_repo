package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.List;

public class FinderByPrice implements Finder {

    @Override
     public void findBy(String searchValue, List<BaseTour> list) throws FindByPriceException {

        int counter = 0;

        for (BaseTour tour : list) {
            if(searchValue.equals(tour.getPrice().toString())){
                System.out.println(tour.getInfo());
                counter ++;
            }
        }
        if (counter == 0) {
            throw new FindByPriceException(searchValue);
            //System.out.println("No tours with " + searchValue + " price!");
        }

    }

}
