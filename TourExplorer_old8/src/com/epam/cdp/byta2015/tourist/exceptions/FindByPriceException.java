package com.epam.cdp.byta2015.tourist.exceptions;

public class FindByPriceException extends Exception {
    private String msg;

    public FindByPriceException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return "[FindByTypeException]: There are not records with price ='" + msg + "'!";
    }
}
