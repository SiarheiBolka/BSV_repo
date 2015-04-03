package com.epam.cdp.byta2015.module3.lecture2.demo.runner;

import java.awt.List;

import com.epam.cdp.byta2015.module3.lecture2.demo.model.Child;

public class Utils {

	public static void findByName(String searchValue, java.util.List<Child> list) {
		for (Child child : list) {
			if(searchValue.equals(child.getFirstName())){
				System.out.println(child.getInfo());
			}
		}
	}
	
}
