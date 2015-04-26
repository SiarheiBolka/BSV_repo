package com.epam.cdp.byta2015.tourist.datareaders;

import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.List;

public interface Reader {

    //List<BaseTour> readAll();

    List<BaseTour> readAll(String EMPLOYEE_INFO_TXT);
}

