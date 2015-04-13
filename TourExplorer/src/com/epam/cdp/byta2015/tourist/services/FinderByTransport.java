package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.ArrayList;
import java.util.List;

public class FinderByTransport {

    private static List<BaseTour> findByTransportList = new ArrayList<BaseTour>();

    public List<BaseTour> findBy(String searchValue){

        int counter = 0;

        for (BaseTour tour : Runner.getList()) {
            if(searchValue.equals(tour.getTransport())){
                System.out.println(tour.getInfo());
                counter ++;
            }
        }
       /* if (counter == 0) {
            throw new FindByTransportException(searchValue);
        }*/
        return findByTransportList;
    }

    public static List<BaseTour> getFindByTransportList() {
        return findByTransportList;
    }

    public static void setFindByTransportList(List<BaseTour> findByTransportList) {
        FinderByTransport.findByTransportList = findByTransportList;
    }

}