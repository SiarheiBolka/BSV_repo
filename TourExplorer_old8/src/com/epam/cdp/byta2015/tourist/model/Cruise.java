package com.epam.cdp.byta2015.tourist.model;

import java.util.List;


public class Cruise extends BaseTour {

    protected List<String> countries;

    public Cruise() {
    }

    public Cruise(Integer id, String typeDesc, String food, String transport, Integer duration, Double price, List<String> countries) {
        super(id, typeDesc, food, transport, duration, price);
        this.countries = countries;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getInfo() {
        return super.getInfo() + "; Countries: " + this.countries;
    }
}
