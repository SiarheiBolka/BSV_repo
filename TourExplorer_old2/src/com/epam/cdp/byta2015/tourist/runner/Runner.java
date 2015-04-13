package com.epam.cdp.byta2015.tourist.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.epam.cdp.byta2015.tourist.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.datareaders.XmlFileReader;
import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.services.Print;

public class Runner {

	private static final String EMPLOYEE_INFO_TXT = "catalog.txt";
	private static final String DATABASE_PROPERTIES = "database.properties";
	private static final String TOUR_INFO_XML = "tourFeed.xml";

	static Properties pr = new Properties();
	
	static {
		try {
			FileInputStream inp = new FileInputStream(DATABASE_PROPERTIES);
			pr.load(inp);
			inp.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	static String databaseURL1 = pr.getProperty("dbURL1");
	static String databaseURL2 = pr.getProperty("dbURL2");
	static String databaseURL3 = pr.getProperty("dbURL3");
	static String user = pr.getProperty("user");
	static String password = pr.getProperty("password");
	static String driverName = pr.getProperty("driver");
	
	public static void main(String[] args) {
		
		boolean repeat = true;
		
		List<BaseTour> list = new ArrayList<BaseTour>();
		List<BaseTour> list1 = new ArrayList<BaseTour>();
		List<BaseTour> list2 = new ArrayList<BaseTour>();
		List<BaseTour> list3 = new ArrayList<BaseTour>();
		
		while (repeat) {
			System.out.println("Menu");
			System.out.println("0 - Exit");
			System.out.println("1 - Load data from .txt file");
			System.out.println("2 - Load data from DB");
			System.out.println("3 - Load data from .xml file");
			System.out.println("4 - Print tours");
			System.out.println("5 - Find a tour");
			System.out.println("6 - Sort tours");
			
			int action;
			Scanner scanner = new Scanner (System.in);
			action = scanner.nextInt();
			
			switch(action) {
			
			case 0:
				repeat = false;
				System.out.println("Completed!");
				break;
				
			case 1:
				list.clear();
				try {
					File myDir = new File ("../TourExplorer/");
					System.out.println(myDir + (myDir.isDirectory() ? " is" : " is not") + " a directory.");
 					File myFile = new File (myDir, EMPLOYEE_INFO_TXT);
					if (!myFile.exists())
						myFile.createNewFile();
					System.out.println(myFile + (myFile.exists() ? " exists" : " doesn't exist"));
				} catch (IOException e1) {
					System.out.println("File error: " + e1);
				}
				
				//Read file
				TxtFileReader txtReader = new TxtFileReader(EMPLOYEE_INFO_TXT);
				try {
					list = txtReader.readInfo();
					System.out.println("Data from .txt file are loaded!\n");
					
				} catch (NullPointerException ex) {
					System.out.println(ex.getMessage());
				}
				
				break;
				
			case 2:
					list.clear();
					//loading data from first db
					try {
						Class.forName(driverName);
						System.out.println("OK! Driver is registered! ");
					} catch (ClassNotFoundException e) {
						System.out.println("Mysql JDBC driver not found");
					}
					Connection c1 = null;
					
					try {
						c1 = DriverManager.getConnection(databaseURL1, user, password);
						System.out.println("Connect");
					} catch (SQLException e) {
						System.out.println("SQLException " + e.getMessage());
					}
					
					DatabaseReader dbReader1 = new DatabaseReader(c1);
					try{
						list1 = dbReader1.readInfoFromFirstDB();
					} catch(NullPointerException ex) {
						System.out.println("Error during loading data from DB!");
					}
					
					try {
						if (c1 != null)
							c1.close();
					} catch (SQLException e) {}
					
					//loading data from second db
					try {
						Class.forName(driverName);
						System.out.println("OK! Driver is registered! ");
					} catch (ClassNotFoundException e) {
						System.out.println("Mysql JDBC driver not found");
					}
					Connection c2 = null;
					
					try {
						c2 = DriverManager.getConnection(databaseURL2, user, password);
						System.out.println("Connect");
					} catch (SQLException e) {
						System.out.println("SQLException " + e.getMessage());
					}
					
					DatabaseReader dbReader2 = new DatabaseReader(c2);
					try{
						list2 = dbReader2.readInfoFromSecondDB();
					} catch(NullPointerException ex) {
						System.out.println("Error during loading data from DB!");
					}
					
					try {
						if (c2 != null)
							c2.close();
					} catch (SQLException e) {}
					
					//loading data from third db
					try {
						Class.forName(driverName);
						System.out.println("OK! Driver is registered! ");
					} catch (ClassNotFoundException e) {
						System.out.println("Mysql JDBC driver not found");
					}
					Connection c3 = null;
					
					try {
						c3 = DriverManager.getConnection(databaseURL3, user, password);
						System.out.println("Connect");
					} catch (SQLException e) {
						System.out.println("SQLException " + e.getMessage());
					}
					
					DatabaseReader dbReader3 = new DatabaseReader(c3);
					try{
						list3 = dbReader3.readInfoFromThirdDB();
					} catch(NullPointerException ex) {
						System.out.println("Error during loading data from DB!");
					}
					
					try {
						if (c3 != null)
							c3.close();
					} catch (SQLException e) {}
								
					list.addAll(list1);
					list.addAll(list2);
					list.addAll(list3);
					
				break;
				
			case 3:
				
				XmlFileReader xmlReader = new XmlFileReader(TOUR_INFO_XML);
				try{
					list = xmlReader.readInfo();
				} catch(NullPointerException ex) {
					System.out.println("Error during loading data from .xml file! ");
				}
					
				break;
				
			case 4:
				Print.printAvailableTours(list);
				break;
				
			default:
					break;
			}
		}

	}

}
