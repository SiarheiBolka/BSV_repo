package com.epam.cdp.byta2014.module4.lecture3.demo.model;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	
	public Employee() {}
	
	public Employee(int id, String firstName, String lastName, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String toString() {
		return "Employee: \n" +
				"-ID: " + getId() + "\n" +
				"-first name: " + getFirstName() + "\n" +
				"-last name: " + getLastName() + "\n" +
				"-salary: " + getSalary() + "\n;\n";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
