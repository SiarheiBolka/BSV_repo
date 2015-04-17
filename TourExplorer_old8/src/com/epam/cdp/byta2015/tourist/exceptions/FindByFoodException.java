package com.epam.cdp.byta2015.tourist.exceptions;

public class FindByFoodException extends Exception {

    private String msg;

    public FindByFoodException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return "[FindByTypeException]: There are not records with food ='" + msg + "'!";
    }
}
