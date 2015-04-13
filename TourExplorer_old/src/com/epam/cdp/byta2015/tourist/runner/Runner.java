package com.epam.cdp.byta2015.tourist.runner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.services.Print;

public class Runner {

	private static final String EMPLOYEE_INFO_TXT = "catalog.txt";
	
	public static void main(String[] args) {
		
		boolean repeat = true;
		
		List<BaseTour> list = new ArrayList<BaseTour>();
		
		while (repeat) {
			System.out.println("Menu");
			System.out.println("1 - Load data from .txt file");
			System.out.println("2 - Load data from DB");
			System.out.println("3 - Load data from .xml file");
			System.out.println("4 - Print available Tours");
			
			int action;
			Scanner scanner = new Scanner (System.in);
			action = scanner.nextInt();
			
			switch(action) {
			
			case 0:
				repeat = false;
				System.out.println("Completed!");
				break;
				
			case 1:
				try {
					File myDir = new File ("../TourExplorer/");
					System.out.println(myDir + (myDir.isDirectory() ? " is" : " is not") + " a directory.");
 					File myFile = new File (myDir, "catalog.txt");
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
				break;
				
			case 3:
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
