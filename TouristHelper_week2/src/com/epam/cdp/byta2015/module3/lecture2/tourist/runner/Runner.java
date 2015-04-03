package com.epam.cdp.byta2015.module3.lecture2.tourist.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Tour;
import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;

public class Runner {

	public static void main(String[] args) {
		boolean repeat = true;
		
	
		List<Offer> list = new ArrayList<>();

		while(repeat) {
			System.out.println("1. =add tour to the list ");
			System.out.println("2. =find a tour by type (Cruise, Rest, Shopping)");
			System.out.println("3. =find a tour by food (All inclusive, Breakfast, Breakfast and dinner, No food)");
			System.out.println("4. =find a tour by transport (Train, Bus, Plane)");
			System.out.println("5. =find a tour by days count (7, 10, 14)");
			System.out.println("6. =show list");
			System.out.println("0. =exit");
			
			Scanner scanner = new Scanner (System.in);
			int action = scanner.nextInt();
			
			switch(action){
			case 0: 
				repeat = false;
				System.out.println("Completed!");
				break;
				
			case 1:
				System.out.println("Type the type of tour (Cruise, Rest, Shopping):");
				String typeOfTour = new Scanner(System.in).nextLine();
				System.out.println("Type the type of transport (Train, Bus, Plane):");
				String transport = new Scanner(System.in).nextLine();
				System.out.println("Type the type of food (All inclusive, Breakfast, Breakfast and dinner, No food):");
				String food = new Scanner(System.in).nextLine();
				System.out.println("Type the days count (7, 10, 14):");
				String daysCount = new Scanner(System.in).nextLine();
				
	
				list.add(new Offer(typeOfTour, transport, food, daysCount));
				
				
				break;

			case 2:
				System.out.println("Type a tour type to search");
				String tourType = new Scanner(System.in).nextLine();
				Utils.findByType(tourType, list);
				
				break;
				
			case 3:
				System.out.println("Type a food type to search");
				String foodType = new Scanner(System.in).nextLine();
				Utils.findByFood(foodType, list);
				
				break;
				
			case 4:
				System.out.println("Type a transport type to search");
				String transpType = new Scanner(System.in).nextLine();
				Utils.findByTransport(transpType, list);
				
				break;
				
			case 5:
				System.out.println("Type days count to search");
				String daysCont = new Scanner(System.in).nextLine();
				Utils.findByDays(daysCont, list);
				
				break;
				
			case 6:
				for(Offer tour : list){
					System.out.println(tour.getInfo());
				}
				
				break;
			default: 
				System.out.println("Incorrect value! Please, try again!");
				break;
			}
		}
	}
}
