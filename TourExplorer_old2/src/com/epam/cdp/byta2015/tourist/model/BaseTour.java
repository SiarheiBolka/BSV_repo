package com.epam.cdp.byta2015.tourist.model;

public abstract class BaseTour {

	protected Integer id;
	protected String typeDesc;
	protected String transport;
	protected Integer duration;
	protected Double price;
	
	public BaseTour(Integer id, String typeDesc, String food, String transport, Integer duration, Double price) {
		this.id = id;
		this.typeDesc = typeDesc;
		this.transport = transport;
		this.duration = duration;
		this.price = price;
	}
	
	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getInfo(){
		return "Id: " + this.id + ", Type: " + this.typeDesc + ", Duration: " + this.duration  + ", Price: " + this.price ;
	}
}
