package com.epam.cdp.byta2015.tourist.datareaders;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by Sergik on 08.04.2015.
 */
public class DatabaseReader implements Reader {

    private static final String DATABASE_PROPERTIES = "database.properties";

    private static Properties pr = new Properties();

    static {
        try {
            FileInputStream inp = new FileInputStream(DATABASE_PROPERTIES);
            pr.load(inp);
            inp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String databaseURL = pr.getProperty("dbURL");
    static String user = pr.getProperty("user");
    static String password = pr.getProperty("password");
    static String driverName = pr.getProperty("driver");

    List<BaseTour> list = new ArrayList<BaseTour>();

    @Override
    public List<BaseTour> readAll() {

        String[] dbNamesList = {"shoppings", "cruises", "excursions"};
        String query;
        PreparedStatement prState = null;
        ResultSet rs = null;
        Connection c = null;

        try {
            Class.forName(driverName);
            System.out.println("OK! Driver is registered! ");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql JDBC driver not found");
        }

        for( String dbName : dbNamesList ) {
            try {
                c = DriverManager.getConnection(databaseURL+dbName, user, password);
                System.out.println("Connect");
            } catch (SQLException e) {
                System.out.println("SQLException " + e.getMessage());
            }

            query = "SELECT * FROM " + dbName + "; ";
            try {
                prState = c.prepareStatement(query);
                rs = prState.executeQuery();

                switch (dbName){
                    case "shoppings":
                        while (rs.next()) {
                            Shopping tour = new Shopping(
                                    rs.getInt("id"),
                                    rs.getString("type"),
                                    rs.getString("food"),
                                    rs.getString("transport"),
                                    rs.getInt("duration"),
                                    rs.getDouble("price"),
                                    rs.getString("country"),
                                    rs.getString("nighttransfer"));
                            list.add(tour);
                        }
                        break;

                    case "cruises":
                        while (rs.next()) {
                            String[] countries = rs.getString("countries").split(",");
                            List<String> countriesList = new ArrayList<String>();
                            int counter = 0;

                            while (countries.length> counter) {
                                countriesList.add(countries[counter]);
                                counter++;
                            }

                        Cruise tour = new Cruise(
                                rs.getInt("id"),
                                rs.getString("type"),
                                rs.getString("food"),
                                rs.getString("transport"),
                                rs.getInt("duration"),
                                rs.getDouble("price"),
                                countriesList);

                        list.add(tour);
                    }
                    break;

                    case "excursions":
                        while (rs.next()) {
                            String[] destinations = rs.getString("destination").split(",");
                            List<String> destinationsList = new ArrayList<String>();
                            int counter = 0;

                            while (destinations.length> counter) {
                                destinationsList.add(destinations[counter]);
                                counter++;
                            }

                            Excursion tour = new Excursion(
                                    rs.getInt("id"),
                                    rs.getString("type"),
                                    rs.getString("food"),
                                    rs.getString("transport"),
                                    rs.getInt("duration"),
                                    rs.getDouble("price"),
                                    rs.getString("country"),
                                    destinationsList);
                            list.add(tour);
                        }
                        break;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException ex) {
                System.out.println("Error during loading data from DB!");
            } finally {
                try {
                    if (rs != null)
                        rs.close();
                } catch (SQLException e) {
                }
                try {
                    if (prState != null)
                        prState.close();
                } catch (SQLException e) {
                }
                try {
                    if (c != null)
                        c.close();
                } catch (SQLException e) {
                }
            }
        }
        return list;
    }

}