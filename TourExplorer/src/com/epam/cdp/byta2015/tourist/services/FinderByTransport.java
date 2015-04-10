package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByTransportException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.List;

public class FinderByTransport implements Finder {

    public void findBy(String searchValue, List<BaseTour> list){

        int counter = 0;

        for (BaseTour tour : list) {
            if(searchValue.equals(tour.getTransport())){
                System.out.println(tour.getInfo());
                counter ++;
            }
        }
       /* if (counter == 0) {
            throw new FindByTransportException(searchValue);
        }*/

    }

}