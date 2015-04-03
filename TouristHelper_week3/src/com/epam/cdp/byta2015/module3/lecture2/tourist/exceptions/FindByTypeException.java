package com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions;

public class FindByTypeException extends Exception{
	
	private String msg;
	
	public FindByTypeException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return "[FindByTypeException]: There are not records with type ='" + msg + "'!";
	}

}
