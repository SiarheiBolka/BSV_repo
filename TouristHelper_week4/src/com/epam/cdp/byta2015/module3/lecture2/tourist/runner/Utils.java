package com.epam.cdp.byta2015.module3.lecture2.tourist.runner;

import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByDaysException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByTransportException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;


public class Utils {

	public static void findByType(String searchValue, java.util.List<Offer> list) throws FindByTypeException {
		int counter = 0;
		for (Offer tour : list) {
			if(searchValue.equals(tour.getTypeofTour())){
				System.out.println(tour.getInfo());
				counter ++;
			}
		}
		if (counter == 0) {
			throw new FindByTypeException(searchValue);
		}
	}
	
	public static void findByFood(String searchValue, java.util.List<Offer> list) throws FindByFoodException {
		int counter = 0;
		for (Offer tour : list) {
			if(searchValue.equals(tour.getFood())){
				System.out.println(tour.getInfo());
				counter ++;
			}
		}
		if (counter == 0) {
			throw new FindByFoodException(searchValue);
		}
	}
	
	public static void findByTransport(String searchValue, java.util.List<Offer> list) throws FindByTransportException{
		int counter = 0;
		for (Offer tour : list) {
			if(searchValue.equals(tour.getTransport())){
				System.out.println(tour.getInfo());
				counter ++;
			}
		}
		if (counter == 0) {
			throw new FindByTransportException(searchValue);
		}
	}

	public static void findByDays(String searchValue, java.util.List<Offer> list) throws FindByDaysException{
		int counter = 0;
		for (Offer tour : list) {			
			if(searchValue.equals(tour.getDaysCount())){
				System.out.println(tour.getInfo());
				counter ++;
			}
		}
		if (counter == 0) {
			throw new FindByDaysException(searchValue);
		}
	}

	/*public static void sortBy(String sortType, java.util.List<Offer> list ) {
		for (Offer tour : list) {			
			//TODO
			}
		}
		
	}	*/

}
