package com.epam.cdp.byta2015.tourist.datareaders;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.FileChecker;
import sun.reflect.generics.tree.BaseType;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseReader implements Reader {
    public static Connection c = null;
    static String databaseURL;
    static String user;
    static String password;
    static String driverName;

    private static final String DATABASE_PROPERTIES = "database.properties";
    private List<BaseTour> list = new ArrayList<BaseTour>();
    private static Properties pr = new Properties();

    static {
        try {
            FileInputStream inp = new FileInputStream(DATABASE_PROPERTIES);
            pr.load(inp);
            inp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        databaseURL = pr.getProperty("dbURL");
        user = pr.getProperty("user");
        password = pr.getProperty("password");
        driverName = pr.getProperty("driver");

        try {
            Class.forName(getDriverName());
            System.out.println("OK! Driver is registered! ");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql JDBC driver not found");
        }

        try {
            c = DriverManager.getConnection(getDatabaseURL()+"tours", getUser(), getPassword());
            System.out.println("Connect");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }

    @Override
    public List<BaseTour> readAll() {

        FileChecker.checkFile(DATABASE_PROPERTIES);

        String[] tablesNamesList = {"shoppings", "cruises", "excursions"};
        String query;
        PreparedStatement prState = null;
        ResultSet resSet = null;

        for( String tableName : tablesNamesList ) {

            query = "SELECT * FROM " + tableName + "; ";

            try {
                prState = c.prepareStatement(query);
                resSet = prState.executeQuery();

                switch (tableName){
                    case "shoppings":
                        while (resSet.next()) {
                            Shopping tour = new Shopping(
                                    resSet.getInt("id"),
                                    resSet.getString("type"),
                                    resSet.getString("food"),
                                    resSet.getString("transport"),
                                    resSet.getInt("duration"),
                                    resSet.getDouble("price"),
                                    resSet.getString("country"),
                                    resSet.getString("nighttransfer"));
                            list.add(tour);
                        }
                        break;

                    case "cruises":
                        while (resSet.next()) {
                            String[] countries = resSet.getString("countries").split(",");
                            List<String> countriesList = new ArrayList<String>();
                            int counter = 0;

                            while (countries.length> counter) {
                                countriesList.add(countries[counter]);
                                counter++;
                            }

                            Cruise tour = new Cruise(
                                    resSet.getInt("id"),
                                    resSet.getString("type"),
                                    resSet.getString("food"),
                                    resSet.getString("transport"),
                                    resSet.getInt("duration"),
                                    resSet.getDouble("price"),
                                    countriesList);

                            list.add(tour);
                        }
                    break;

                    case "excursions":
                        while (resSet.next()) {
                            String[] destinations = resSet.getString("destination").split(",");
                            List<String> destinationsList = new ArrayList<String>();
                            int counter = 0;

                            while (destinations.length> counter) {
                                destinationsList.add(destinations[counter]);
                                counter++;
                            }

                            Excursion tour = new Excursion(
                                    resSet.getInt("id"),
                                    resSet.getString("type"),
                                    resSet.getString("food"),
                                    resSet.getString("transport"),
                                    resSet.getInt("duration"),
                                    resSet.getDouble("price"),
                                    resSet.getString("country"),
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
                    if (resSet != null)
                        resSet.close();
                } catch (SQLException e) {
                }
                try {
                    if (prState != null)
                        prState.close();
                } catch (SQLException e) {
                }

            }
        }
        return list;
    }

    public static String getDatabaseURL() {
        return databaseURL;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDriverName() {
        return driverName;
    }
}