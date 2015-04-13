package com.epam.cdp.byta2015.module3.lecture2.tourist.model;

public class Tour {
	
	protected String typeofTour;
	protected String transport;
	
	public Tour(String typeofTour, String typeOfTransport) {
		this.typeofTour = typeofTour;
		this.transport = typeOfTransport;
	}

	public String getTypeofTour() {
		return typeofTour;
	}

	public void setTypeofTour(String typeofTour) {
		this.typeofTour = typeofTour;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}
	
	public String getInfo(){
		return "Type of tour: " + this.typeofTour + ", Transport: " + this.transport;
	}

}
