package com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions;

public class InvalidReadDataException extends Exception {
	
	private String line;
	
	public InvalidReadDataException(String line) {
		this.line = line;
	}

	public String getMessage() {
		return "[InvalidReadDataException]: Corrupted data in line ='" + line + "'!";
	}
}
