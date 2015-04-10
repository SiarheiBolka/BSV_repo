package com.epam.cdp.byta2015.tourist.services;


import com.epam.cdp.byta2015.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTransportException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.List;



public interface Finder {
    public void findBy(String searchValue, List<BaseTour> list) throws FindByPriceException;
}
