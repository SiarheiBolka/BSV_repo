package com.epam.cdp.byta2015.tourist.exceptions;

public class FindByTransportException extends Exception{
    private String msg;

    public FindByTransportException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return "[FindByTypeException]: There are not records with transport ='" + msg + "'!";
    }
}
