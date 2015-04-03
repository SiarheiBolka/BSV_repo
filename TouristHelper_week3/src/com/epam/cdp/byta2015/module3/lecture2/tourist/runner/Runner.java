package com.epam.cdp.byta2015.module3.lecture2.tourist.runner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.epam.cdp.byta2015.module3.lecture2.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.module3.lecture2.tourist.datawriters.TxtFileWriter;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByDaysException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByTransportException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.InvalidReadDataException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;

public class Runner {
	private static final String EMPLOYEE_INFO_TXT = "Catalog.txt";
	public final static String[] typeList = {"Cruise" , "Rest" , "Shopping" };
	public final static String[] foodList = {"All_inclusive" , "Breakfast" , "Breakfast_and_dinner", "No_food"};
	public final static String[] transportList = {"Train" , "Bus" , "Plane" };
	public final static Integer[] daysList = {7, 10, 14};
	
	public static void main(String[] args) {
		boolean repeat = true;
	
		List<Offer> list = new ArrayList<Offer>();

		while(repeat) {
			System.out.println("Menu ");
			System.out.println("1. =show offers list (load from txt-file) ");
			System.out.println("2. =add new offer manually ");
			System.out.println("3. =find a tour by type " + Arrays.toString(typeList));
			System.out.println("4. =find a tour by transport " + Arrays.toString(transportList));
			System.out.println("5. =find a tour by food " + Arrays.toString(foodList));
			System.out.println("6. =find a tour by days count " + Arrays.toString(daysList));
			System.out.println("7. =sort list");
			System.out.println("8. =show list");
			System.out.println("0. =exit");
			
			int action;
			Scanner scanner = new Scanner (System.in);
			action = scanner.nextInt();
			
			switch(action){
			
			case 0: 
				repeat = false;
				System.out.println("Completed!");
				break;
				
			case 1:
				try {
					File myDir = new File ("d:/workspace/TouristHelper/");
					System.out.println(myDir + (myDir.isDirectory() ? " is" : " is not") + " a directory.");
					File myFile = new File (myDir, "catalog.txt");
					if (!myFile.exists())
						myFile.createNewFile();
					System.out.println(myFile + (myFile.exists() ? " exists" : " doesn't exist"));
				} catch (IOException e1) {
					System.out.println("File error: " + e1);
				}
				
				System.out.println("\nList of offers:");
				
				//Read file
					TxtFileReader txtReader = new TxtFileReader(EMPLOYEE_INFO_TXT);
				try {
					list = txtReader.readInfo();
					
					for(Offer tour : list){
						System.out.println(tour.getInfo());
					}
					
				} catch (NullPointerException | InvalidReadDataException ex) {
					System.out.println("Error: There are no any offers");
					System.out.println(ex.getMessage());
				}
				
				System.out.println("\n");
				break;
				
			case 2:
				
				String typeOfTour = null;
				String transport = null;
				String food = null;
				int daysCount = 0;
				
				boolean repeatTour = true;
				boolean repeatFood = true;
				boolean repeatTransport = true;
				boolean repeatDays = true;
				
				while (repeatTour) {
					try {
						System.out.println("Type the type of tour " + Arrays.toString(typeList));
						typeOfTour = new Scanner(System.in).nextLine();
						repeatTour = false;
					} catch (InputMismatchException e2) {
						System.out.println("Error: Incorrect tour value");
						repeatTour = true;
					}
				}

				while (repeatTransport) {
					try {
						System.out.println("Type the type of food " + Arrays.toString(foodList));
						food = new Scanner(System.in).nextLine();
						repeatTransport = false;
					} catch (InputMismatchException e2) {
						System.out.println("Error: Incorrect food value");
						repeatTransport = true;
					}
				}
				
				while (repeatFood) {
					try {
						System.out.println("Type the type of transport " + Arrays.toString(transportList));
						transport = new Scanner(System.in).nextLine();
						repeatFood = false;
					} catch (InputMismatchException e2) {
						System.out.println("Error: Incorrect transport value");
						repeatFood = true;
					}
				}
					
				while (repeatDays) {
					try {
						System.out.println("Type the days count " + Arrays.toString(daysList));
						daysCount = new Scanner(System.in).nextInt();
						repeatDays = false;
					} catch (InputMismatchException e2) {
						System.out.println("Error: Incorrect days value");
						repeatDays = true;
					}
				}
				
				Offer offer = new Offer(typeOfTour, transport, food, daysCount);
				try {
					File myDir = new File ("d:/workspace/TouristHelper/");
					System.out.println(myDir + (myDir.isDirectory() ? " is" : " is not") + " a directory.");
					File myFile = new File (myDir, "catalog.txt");
					if (!myFile.exists())
						myFile.createNewFile();
					System.out.println(myFile + (myFile.exists() ? " exists" : " doesn't exist"));
				} catch (IOException e1) {
					System.out.println("File error: " + e1);
				}
				
				//Write file
				TxtFileWriter txtWriter = new TxtFileWriter(EMPLOYEE_INFO_TXT);
				txtWriter.writeInfo(offer);
				
				//Read file
					TxtFileReader txtReader2 = new TxtFileReader(EMPLOYEE_INFO_TXT);
				try {
					list = txtReader2.readInfo();
					
					for(Offer tour : list){
						System.out.println(tour.getInfo());
					}
					
				} catch (NullPointerException | InvalidReadDataException ex) {
					System.out.println(ex.getMessage());
				}
				
				System.out.println("\n");
				break;
				
			case 3:
				System.out.println("Type a tour type to search " + Arrays.toString(typeList));
				String tourType = new Scanner(System.in).nextLine();
				
				try {
					Utils.findByType(tourType, list);
				} catch (FindByTypeException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n");
				break;
				
			case 4:
				System.out.println("Type a transport type to search " + Arrays.toString(transportList));
				String transpType = new Scanner(System.in).nextLine();
				try {
					Utils.findByTransport(transpType, list);
				} catch (FindByTransportException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n");
				break;
				
			case 5:
				System.out.println("Type a food type to search " + Arrays.toString(foodList));
				String foodType = new Scanner(System.in).nextLine();
				try {
					Utils.findByFood(foodType, list);
				} catch (FindByFoodException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n");
				break;
				
			case 6:
				System.out.println("Type days count to search " + Arrays.toString(daysList));
				String daysCont = new Scanner(System.in).nextLine();
				try {
					Utils.findByDays(daysCont, list);
				} catch (FindByDaysException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n");
				break;
			
			case 7:
				boolean repeat1 = true;
				
				while(repeat1) {
					System.out.println("Menu ");
					System.out.println("0. = Main menu");
					System.out.println("1. = Sort by tour type");
					System.out.println("2. = Sort by tour food");
					System.out.println("3. = Sort by tour transport");
					System.out.println("4. = Sort by tour days");
				
					//int sortType = new Scanner(System.in).nextInt();
					
					int sortType;
					Scanner scanner1 = new Scanner (System.in);
					sortType = scanner1.nextInt();
					
					switch(sortType) {
					case 1: 
						Collections.sort(list, new Comparator<Offer>() {
							@Override
							public int compare(Offer offer1, Offer offer2) {
								return  offer1.getTypeofTour().compareTo(offer2.getTypeofTour());
							}
						});
						repeat1 = false;
						break;
								
					case 2: 
						Collections.sort(list, new Comparator<Offer>() {
							@Override
							public int compare(Offer offer1, Offer offer2) {
								return  offer1.getFood().compareTo(offer2.getFood());
							}
						});
						repeat1 = false;
						break;
					
					case 3: 
						Collections.sort(list, new Comparator<Offer>() {
							@Override
							public int compare(Offer offer1, Offer offer2) {
								return  offer1.getTransport().compareTo(offer2.getTransport());
							}
						});
						repeat1 = false;
						break;
			
					case 4: 
						Collections.sort(list, new Comparator<Offer>() {
							@Override
							public int compare(Offer offer1, Offer offer2) {
								int day1 = offer1.getDaysCount();
								int day2 = offer2.getDaysCount();
								
								if(day1 > day2) {
						               return 1;
						        }
						        else if(day1 < day2) {
						               return -1;
						        }
						        else {
						               return 0;
						        }							
							}
						});
						repeat1 = false;
						break;
							
					case 0: 
						repeat1 = false;
						break;
						
					default:
						System.out.println("Incorrect value! Please, try again!");
						break;
					}
				}
					System.out.println("Sorted!\n");
				
			case 8:
				System.out.println("\nList of available offers:");
				if (list.size() != 0) {
					for(Offer tour : list){
						System.out.println(tour.getInfo());
					}
				} else {
					System.out.println("Error: no offers available!");
				}
					
				System.out.println("\n");
				
				break;
				
			default: 
				System.out.println("Incorrect value! Please, try again!");
				break;
			}
			
		}
	}

}