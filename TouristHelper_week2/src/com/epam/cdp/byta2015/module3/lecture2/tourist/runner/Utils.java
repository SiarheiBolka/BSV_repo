package com.epam.cdp.byta2015.module3.lecture2.tourist.runner;

import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;

public class Utils {

	public static void findByType(String searchValue, java.util.List<Offer> list) {
		for (Offer tour : list) {
			if(searchValue.equals(tour.getTypeofTour())){
				System.out.println(tour.getInfo());
			}
		}
	}
	
	public static void findByFood(String searchValue, java.util.List<Offer> list) {
		for (Offer tour : list) {
			if(searchValue.equals(tour.getFood())){
				System.out.println(tour.getInfo());
			}
		}
	}
	
	public static void findByTransport(String searchValue, java.util.List<Offer> list) {
		for (Offer tour : list) {
			if(searchValue.equals(tour.getTransport())){
				System.out.println(tour.getInfo());
			}
		}
	}

	public static void findByDays(String searchValue, java.util.List<Offer> list) {
		for (Offer tour : list) {
			if(searchValue.equals(tour.getDaysCount())){
				System.out.println(tour.getInfo());
			}
		}
	}	
	
}
