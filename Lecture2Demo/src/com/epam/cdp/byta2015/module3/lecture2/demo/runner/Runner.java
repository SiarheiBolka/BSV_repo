package com.epam.cdp.byta2015.module3.lecture2.demo.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.cdp.byta2015.module3.lecture2.demo.model.Child;
import com.epam.cdp.byta2015.module3.lecture2.demo.model.Person;

public class Runner {

	public static void main(String[] args) {
		boolean repeat = true;
		
		Person mother = new Person ("Irina", "Ivanova");
		Person father = new Person ("Ivan", "Ivanov");
		
		List<Child> list = new ArrayList<>();
		
		while(repeat) {
			System.out.println("1. =add child to the list");
			System.out.println("2. =find a child by name");
			System.out.println("3. =show list");
			System.out.println("0. =exit");
			
			Scanner scanner = new Scanner (System.in);
			int action = scanner.nextInt();
			
			switch(action){
			case 0: 
				repeat = false;
				System.out.println("Completed!");
				break;
				
			case 1:
				System.out.println("Type the first name:");
				String firstName = new Scanner(System.in).nextLine();
				System.out.println("Type the last name:");
				String lastName = new Scanner(System.in).nextLine();
				
				list.add(new Child(firstName, lastName, mother, father));
				
				break;
				
			case 2:
				System.out.println("Type a name to search");
				String name = new Scanner(System.in).nextLine();
				Utils.findByName(name, list);
				break;
				
			case 3:
				for(Child child : list){
					System.out.println(child.getInfo());
				}
				
				break;
				
				default: 
					System.out.println("Incorrect value! Please, try again!");
					break;
			}
			
		}

	}

}
