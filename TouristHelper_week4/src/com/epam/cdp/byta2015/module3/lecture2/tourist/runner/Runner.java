package com.epam.cdp.byta2015.module3.lecture2.tourist.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.epam.cdp.byta2015.module3.lecture2.tourist.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.module3.lecture2.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.module3.lecture2.tourist.datareaders.XMLFileReader;
import com.epam.cdp.byta2015.module3.lecture2.tourist.datawriters.TxtFileWriter;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByDaysException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByTransportException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.InvalidReadDataException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;

public class Runner {
	private static final String EMPLOYEE_INFO_XML = "employee_info.xml";
	private static final String DATABASE_PROPERTIES = "database.prop";
	//private static final String EMPLOYEE_INFO_TXT = "employee_info.txt";
	
	static Properties pr = new Properties();
	
	static {
		try {
			FileInputStream inp = new FileInputStream(DATABASE_PROPERTIES);
			pr.load(inp);
			inp.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	static String databaseURL = pr.getProperty("dbURL");
	static String user = pr.getProperty("user");
	static String password = pr.getProperty("password");
	static String driverName = pr.getProperty("driver");
	
	private static final String EMPLOYEE_INFO_TXT = "Catalog.txt";
	public final static String[] typeList = {"Cruise" , "Rest" , "Shopping" };
	public final static String[] transportList = {"Train" , "Bus" , "Plane" };
	public final static String[] foodList = {"All_inclusive" , "Breakfast" , "Breakfast_and_dinner", "No_food"};
	public final static Integer[] daysList = {7, 10, 14};
	
	public static void main(String[] args) {
		boolean repeat = true;
	
		List<Offer> list = new ArrayList<Offer>();

		while(repeat) {
			System.out.println("Menu ");
			System.out.println(" 1. = show offers list (load from .txt file) ");
			System.out.println(" 2. = show offers list (load from DB) ");
			//System.out.println(" 3. = show offers list (load from .xml file) ");
			System.out.println(" 4. = add new offer manually ");
			System.out.println(" 5. = find a tour by type " + Arrays.toString(typeList));
			System.out.println(" 6. = find a tour by transport " + Arrays.toString(transportList));
			System.out.println(" 7. = find a tour by food " + Arrays.toString(foodList));
			System.out.println(" 8. = find a tour by days count " + Arrays.toString(daysList));
			System.out.println(" 9. = sort list");
			System.out.println("10. = show list");
			System.out.println(" 0. = exit");
			
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
				
				System.out.print("Enter offer's number: ");
				int id2 = scanner.nextInt();
				
				try {
					Class.forName(driverName);
					System.out.println("OK! Driver is registered! ");
				} catch (ClassNotFoundException e) {
					System.out.println("Mysql JDBC driver not found");
				}
				Connection c = null;
				try {
					c = DriverManager.getConnection(databaseURL, user, password);
					System.out.println("Connect");
				} catch (SQLException e) {
					System.out.println("SQLException " + e.getMessage());
				}
				
				DatabaseReader dbReader = new DatabaseReader(c);
				try{
					//Offer offer = dbReader.readInfo(id2);
					list = dbReader.readInfo(id2);
					//System.out.println(offer.toString());
				} catch(NullPointerException ex) {
					System.out.println("There is not offer in row =" + id2);
				}
				
				try {
					if (c != null)
						c.close();
				} catch (SQLException e) {}
				
				break;
				
			/*case 3:
				
				System.out.print("Enter offer's number: ");
				int id3 = scanner.nextInt();
				
				XMLFileReader xmlReader = new XMLFileReader(EMPLOYEE_INFO_XML);
				try{
					Offer offer = xmlReader.readInfo(id3);
					System.out.println(offer.toString());
				} catch(NullPointerException ex) {
					System.out.println("There is not offer xxx =" + id3);
				}
				break;
				
				default: 
					System.out.println("Incorrect value! Please, try again.");
					break;
			*/	
			case 4:
				
				String type = null;
				String transport = null;
				String food = null;
				int days = 0;
				
				boolean repeatTour = true;
				boolean repeatFood = true;
				boolean repeatTransport = true;
				boolean repeatDays = true;
				
				while (repeatTour) {
					try {
						System.out.println("Type the type of tour " + Arrays.toString(typeList));
						type = new Scanner(System.in).nextLine();
						repeatTour = false;
					} catch (InputMismatchException e2) {
						System.out.println("Error: Incorrect tour value");
						repeatTour = true;
					}
				}

				while (repeatTransport) {
					try {
						System.out.println("Type the type of food " + Arrays.toString(transportList));
						food = new Scanner(System.in).nextLine();
						repeatTransport = false;
					} catch (InputMismatchException e2) {
						System.out.println("Error: Incorrect food value");
						repeatTransport = true;
					}
				}
				
				while (repeatFood) {
					try {
						System.out.println("Type the type of transport " + Arrays.toString(foodList));
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
						days = new Scanner(System.in).nextInt();
						repeatDays = false;
					} catch (InputMismatchException e2) {
						System.out.println("Error: Incorrect days value");
						repeatDays = true;
					}
				}
				
				Offer offer = new Offer(type, transport, food, days);
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
				
			case 5:
				System.out.println("Type a tour type to search " + Arrays.toString(typeList));
				String tourType = new Scanner(System.in).nextLine();
				
				try {
					Utils.findByType(tourType, list);
				} catch (FindByTypeException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n");
				break;
				
			case 6:
				System.out.println("Type a transport type to search " + Arrays.toString(transportList));
				String transpType = new Scanner(System.in).nextLine();
				try {
					Utils.findByTransport(transpType, list);
				} catch (FindByTransportException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n");
				break;
				
			case 7:
				System.out.println("Type a food type to search " + Arrays.toString(foodList));
				String foodType = new Scanner(System.in).nextLine();
				try {
					Utils.findByFood(foodType, list);
				} catch (FindByFoodException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n");
				break;
				
			case 8:
				System.out.println("Type days count to search " + Arrays.toString(daysList));
				String daysCont = new Scanner(System.in).nextLine();
				try {
					Utils.findByDays(daysCont, list);
				} catch (FindByDaysException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n");
				break;
			
			case 9:
				boolean repeat1 = true;
				
				while(repeat1) {
					System.out.println("Menu ");
					System.out.println("0. = Main menu");
					System.out.println("1. = Sort by tour type");
					System.out.println("2. = Sort by tour transport");
					System.out.println("3. = Sort by tour food");
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
								return  offer1.getTransport().compareTo(offer2.getTransport());
							}
						});
						repeat1 = false;
						break;
								
					case 3: 
						Collections.sort(list, new Comparator<Offer>() {
							@Override
							public int compare(Offer offer1, Offer offer2) {
								return  offer1.getFood().compareTo(offer2.getFood());
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
				
			case 10:
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
