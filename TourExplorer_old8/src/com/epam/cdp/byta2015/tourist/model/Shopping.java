package com.epam.cdp.byta2015.tourist.model;


public class Shopping extends BaseTour {

    protected String nightTransfer;
    protected String country;

    public Shopping() {
    }

    public Shopping(Integer id, String typeDesc, String food, String transport, Integer duration, Double price, String country, String nightTransfer) {
        super(id, typeDesc, food, transport, duration, price);
        this.country = country;
        this.nightTransfer = nightTransfer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNightTransfer(String nightTransfer) {
        this.nightTransfer = nightTransfer;
    }

    public String getNightTransfer() {
        return nightTransfer;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Country: " + this.country + ", NightTransfer: " + this.nightTransfer;
    }

}
