package com.epam.cdp.byta2014.module4.lecture3.demo.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.epam.cdp.byta2014.module4.lecture3.demo.datareaders.TxtFileReader;
import com.epam.cdp.byta2014.module4.lecture3.demo.model.Employee;

public class Runner {

	private static final String EMPLOYEE_INFO_TXT = "employee_info.txt";

	public static void main(String[] args) {
		boolean repeat = true;

		while (repeat) {
			System.out.println("1. - Read from .txt file");
			System.out.println("2. - Read from DB");
			System.out.println("3. - Read from .xml");
			System.out.println("0. - exit");
			System.out.println("Specify your action: ");

			Scanner scanner = new Scanner(System.in);
			int action = scanner.nextInt();

			switch (action) {
			case 0:
				repeat = false;
				System.out.println("Completed");
				break;

			case 1:
				System.out.print("Enter eployee's ID: ");
				int id1 = scanner.nextInt();

				TxtFileReader txtReader = new TxtFileReader(EMPLOYEE_INFO_TXT);
				try {
					Employee employee = txtReader.readInfo(id1);
					System.out.println(employee.toString());
				} catch (NullPointerException ex) {
					System.out.println("There is not employee with id=" + id1);
				}

				break;

			case 2:
				break;

			case 3:
				break;

			default:
				System.out.println("Incorrect value! Please, try again.");
				break;
			}
		}

	}

}
