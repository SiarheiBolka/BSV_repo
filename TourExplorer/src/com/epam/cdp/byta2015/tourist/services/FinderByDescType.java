package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.runner.Runner;

import java.util.ArrayList;
import java.util.List;

public class FinderByDescType {

    private static List<BaseTour> findByDescTypeList = new ArrayList<BaseTour>();

    public List<BaseTour> findBy(String searchValue){

        int counter = 0;

        for (BaseTour tour : Runner.getList()) {
            if(searchValue.equals(tour.getTypeDesc())){
                findByDescTypeList.add(tour);
                counter ++;
            }
        }
        /*if (counter == 0) {
            throw new FindByTypeException(searchValue);
        }*/

        return findByDescTypeList;
    }

    public static void setFindByDescTypeList(List<BaseTour> findByDescTypeList) {
        FinderByDescType.findByDescTypeList = findByDescTypeList;
    }

    public static List<BaseTour> getFindByDescTypeList() {
        return findByDescTypeList;
    }

}
