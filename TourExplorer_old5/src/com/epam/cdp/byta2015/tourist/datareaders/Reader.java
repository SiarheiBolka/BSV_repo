package com.epam.cdp.byta2015.tourist.datareaders;

import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Siarhei_Bolka on 4/8/2015.
 */
public interface Reader {

    public List<BaseTour> readAll();

}

