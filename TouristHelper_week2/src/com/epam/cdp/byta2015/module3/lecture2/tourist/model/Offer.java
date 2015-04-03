package com.epam.cdp.byta2015.module3.lecture2.tourist.model;

public class Offer extends Tour{
	
	protected String food;
	protected String daysCount;
	
	public Offer(String typeofTour, String typeOfTransport){
		super(typeofTour, typeOfTransport);
	}
	
	public Offer(String typeofTour, String typeOfTransport, String food, String daysCount){
			super(typeofTour, typeOfTransport);
			this.food = food;
			this.daysCount = daysCount;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(String daysCount) {
		this.daysCount = daysCount;
	}
		
	public String getInfo(){
		return super.getInfo() + ", Food: " + this.food+ ", Dayscount: " + this.daysCount;
	}
	

}
