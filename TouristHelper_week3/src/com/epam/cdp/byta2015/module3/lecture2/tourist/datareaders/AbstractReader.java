package com.epam.cdp.byta2015.module3.lecture2.tourist.datareaders;

import java.util.List;

import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.InvalidReadDataException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;

public abstract class AbstractReader {
	
	public abstract List<Offer> readInfo() throws InvalidReadDataException;

}
