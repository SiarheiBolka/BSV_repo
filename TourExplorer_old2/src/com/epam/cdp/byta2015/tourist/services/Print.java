package com.epam.cdp.byta2015.tourist.services;

import java.util.ArrayList;
import java.util.List;

import com.epam.cdp.byta2015.tourist.model.BaseTour;

public class Print {

	List<BaseTour> list = new ArrayList<BaseTour>();
	
	public static void printAvailableTours(List<BaseTour> list) {
		System.out.println("\nList of available offers:");
		if (list.size() != 0) {
			for(BaseTour baseTour : list){
				System.out.println(baseTour.getInfo());
			}
		} else {
			System.out.println("Error: no offers available!");
		}
			
		System.out.println("\n");
	} 

}
