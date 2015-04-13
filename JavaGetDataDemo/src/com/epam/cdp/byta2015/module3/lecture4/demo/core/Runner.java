package com.epam.cdp.byta2015.module3.lecture4.demo.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.epam.cdp.byta2015.module3.lecture4.demo.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.module3.lecture4.demo.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.module3.lecture4.demo.datareaders.XMLFileReader;
import com.epam.cdp.byta2015.module3.lecture4.demo.model.Employee;

public class Runner {
	
	private static final String EMPLOYEE_INFO_XML = "employee_info.xml";
	private static final String DATABASE_PROPERTIES = "database.prop";
	private static final String EMPLOYEE_INFO_TXT = "employee_info.txt";
	
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
	
	public static void main(String[] args) {
		boolean repeat = true;
		
		while(repeat) {
			System.out.println("1. - Read from .txt file");
			System.out.println("2. - Read from DB");
			System.out.println("3. - Read from .xml");
			System.out.println("0. - exit");
			System.out.println("Specify your action: ");			
			
			Scanner scanner = new Scanner(System.in);
			int action = scanner.nextInt();
			
			switch(action){
			case 0: 
				repeat = false;
				System.out.println("Completed");
				break;
				
			case 1:
				System.out.print("Enter eployee's ID: ");
				int id1 = scanner.nextInt();
				
				TxtFileReader txtReader = new TxtFileReader(EMPLOYEE_INFO_TXT);
				try{
					Employee employee = txtReader.readInfo(id1);
					System.out.println(employee.toString());
				} catch(NullPointerException ex) {
					System.out.println("There is not employee with id=" + id1);
				}
				
				break;
				
			case 2:
				System.out.print("Enter eployee's ID: ");
				int id2 = scanner.nextInt();
				
				try {
					Class.forName(driverName);
					System.out.println("OK !!!!");
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
					Employee employee = dbReader.readInfo(id2);
					System.out.println(employee.toString());
				} catch(NullPointerException ex) {
					System.out.println("There is not employee with id=" + id2);
				}
				
				try {
					if (c != null)
						c.close();
				} catch (SQLException e) {}
				break;
				
			case 3: 
				System.out.print("Enter eployee's ID: ");
				int id3 = scanner.nextInt();
				
				XMLFileReader xmlReader = new XMLFileReader(EMPLOYEE_INFO_XML);
				try{
					Employee employee = xmlReader.readInfo(id3);
					System.out.println(employee.toString());
				} catch(NullPointerException ex) {
					System.out.println("There is not employee with id=" + id3);
				}
				break;
				
				default: 
					System.out.println("Incorrect value! Please, try again.");
					break;
			}
		}

	}

}
