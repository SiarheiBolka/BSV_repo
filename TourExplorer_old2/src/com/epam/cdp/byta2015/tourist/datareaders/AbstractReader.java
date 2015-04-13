package com.epam.cdp.byta2015.tourist.datareaders;

import java.util.List;

import com.epam.cdp.byta2015.tourist.model.BaseTour;

public abstract class AbstractReader {

	public List<BaseTour> readInfo() {
		return null;
	}

	public List<BaseTour> readInfoFromFirstDB() {
		return null;
	}

	public List<BaseTour> readInfoFromSecondDB() {
		return null;
	}
	
	public List<BaseTour> readInfoFromThirdDB() {
		return null;
	}

}
