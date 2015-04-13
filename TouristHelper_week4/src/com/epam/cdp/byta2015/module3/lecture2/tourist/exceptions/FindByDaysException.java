package com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions;

public class FindByDaysException extends Exception{
	
	private String msg;
	
	public FindByDaysException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return "[FindByDaysException]: There are not records with days ='" + msg + "'!";
	}
}

