package com.epam.cdp.byta2015.tourist.model;

public class Shopping extends BaseTour {
	
	protected String nightTransfer;
	protected String country;

	public Shopping(Integer id, String typeDesc, String food, String transport, Integer duration, Double price, String country, String nightTransfer) {
		super(id, typeDesc, food, transport, duration, price);
		this.country = country;
		this.nightTransfer = nightTransfer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String isNightTransfer() {
		return nightTransfer;
	}

	public void setNightTransfer(String nightTransfer) {
		this.nightTransfer = nightTransfer;
	}
	
	public String getInfo(){
		return "Id: " + this.id + ", Type: " + this.typeDesc + ", Duration: " + this.duration  + ", Price: " + this.price + ", Country: " + this.country + ", NightTransfer: " + this.nightTransfer;
	}

}
