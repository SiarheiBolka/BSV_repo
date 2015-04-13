package com.epam.cdp.byta2015.module3.lecture2.tourist.model;

public class Offer extends Tour{
	
	protected String food;
	protected int daysCount;
	
	public Offer(String typeofTour, String typeOfTransport){
		super(typeofTour, typeOfTransport);
	}
	
	public Offer(String typeofTour, String typeOfTransport, String food, int daysCount){
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

	public int getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(int daysCount) {
		this.daysCount = daysCount;
	}
		
	public String getInfo(){
		return super.getInfo() + ", Food: " + this.food+ ", Days count: " + this.daysCount;
	}

}
