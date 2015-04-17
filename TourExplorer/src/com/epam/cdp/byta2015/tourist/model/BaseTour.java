package com.epam.cdp.byta2015.tourist.model;


import java.util.Comparator;

public class BaseTour {

   // private static String[] searchParameters = {"typeDesc", "food", "transport", "price"};

    private static String[] desctTypeValues = {"Shopping", "Cruise", "Excursion"};

    private static String[] foodValues = {"No_food", "Tea", "AI", "Breakfast"};
    private static String[] transportValues = {"Bus", "Train", "Plane", "Car", "Aurora", "Azura"};

    protected Integer id;
    protected String typeDesc;
    protected String food;
    protected String transport;
    protected Integer duration;
    protected Double price;

    public BaseTour() {}

    public BaseTour(Integer id, String typeDesc, String food, String transport, Integer duration, Double price) {
        this.id = id;
        this.typeDesc = typeDesc;
        this.food = food;
        this.transport = transport;
        this.duration = duration;
        this.price = price;
    }

    public String getInfo(){
        return "Id: " + this.id +
                ", Type: " + this.typeDesc +
                ", Food: " + this.food +
                ", Transport: " + this.transport +
                ", Duration: " + this.duration  +
                ", Price: " + this.price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
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

    public static String[] getDesctTypeValues() {
        return  desctTypeValues;
    }

    public static String[] getFoodValues() {
        return foodValues;
    }

    public static String[] getTransportValues() {
        return transportValues;
    }

}
