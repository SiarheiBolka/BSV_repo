package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.List;

public class FinderByDescType implements Finder{

    public void findBy(String searchValue, List<BaseTour> list){

        int counter = 0;

        for (BaseTour tour : list) {
            if(searchValue.equals(tour.getTypeDesc())){
                System.out.println(tour.getInfo());
                counter ++;
            }
        }
        /*if (counter == 0) {
            throw new FindByTypeException(searchValue);
        }*/

    }

}
