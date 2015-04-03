package com.epam.cdp.byta2015.module3.lecture2.demo.model;

public class Child extends Person{

	private Person mother;
	private Person father;
	
	public Child(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Child(String firstName, String lastName, Person mother, Person father){
		super(firstName, lastName);
		this.mother = mother;
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}
	
	public String getInfo() {
		return super.getInfo() + "\n Mother: " + mother.getInfo() + "\n Father: " + father.getInfo();
	}

}
