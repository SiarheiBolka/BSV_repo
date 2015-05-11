package com.epam.cdp.byta2015.tourist.adders;

import com.epam.cdp.byta2015.tourist.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.tourist.model.Shopping;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AdderToDatabase {

    private Shopping tour = new Shopping();

    public void addNewShopping() {

        tour.setId(4);
        tour.setTypeDesc("Shopping");
        tour.setFood("AI");
        tour.setTransport("Bus");
        tour.setDuration(4);
        tour.setPrice(15.00);
        tour.setCountry("Belarus");
        tour.setNightTransfer("N");

        String query;
        PreparedStatement prState = null;

        query = "INSERT INTO shoppings (`id`,`type`, `food`, `transport`, `duration`, `price`, `country`, `nighttransfer`) " +
                "VALUES ('" + tour.getId() + "','"+ tour.getTypeDesc() + "','" +tour.getFood() + "','" + tour.getTransport() + "','" + tour.getDuration() +
                "','" + tour.getPrice() + "','" + tour.getCountry() + "','" + tour.getNightTransfer() + "');";

        try {
            prState = DatabaseReader.c.prepareStatement(query);
            prState.executeUpdate();
            System.out.println("Adding finished. Reload data from database to see the changes.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Error during loading data from DB!");
        } finally {
            try {
                if (prState != null)
                prState.close();
                } catch (SQLException e) {
                }
            }
        }
    }


