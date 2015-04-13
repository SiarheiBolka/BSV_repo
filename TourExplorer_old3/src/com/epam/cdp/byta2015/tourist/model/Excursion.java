package com.epam.cdp.byta2015.tourist.model;

import java.util.List;

/**
 * Created by Siarhei_Bolka on 4/8/2015.
 */
public class Excursion extends BaseTour{

    protected List<String> destination;
    protected String country;

    public Excursion(Integer id, String typeDesc, String food, String transport, Integer duration, Double price, String country, List<String> destination) {
        super(id, typeDesc, food, transport, duration, price);
        this.country = country;
        this.destination = destination;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getDestination() {
        return destination;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }

    public String getInfo(){
        return super.getInfo() + ", Country: " + this.country + "; Destinations: " + this.destination;
    }
}
