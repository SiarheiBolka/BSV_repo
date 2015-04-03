package com.epam.cdp.byta2015.module3.lecture2.demo.model;

public class Person {

	protected String firstName;
	protected String lastName;
	
	public Person(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getInfo(){
		return "First name: " + this.firstName + ", Last name: " + this.lastName;
	}

}
