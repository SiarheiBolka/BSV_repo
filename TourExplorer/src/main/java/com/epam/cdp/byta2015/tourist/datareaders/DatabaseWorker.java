package com.epam.cdp.byta2015.tourist.datareaders;

import com.epam.cdp.byta2015.tourist.dataremovers.Remover;
import com.epam.cdp.byta2015.tourist.datawriters.Writer;
import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.FileChecker;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DatabaseWorker implements Reader, Writer, Remover {

    public static Connection c = null;
    static String databaseURL;
    static String user;
    static String password;
    static String driverName;

    private static final String DATABASE_PROPERTIES = "database.properties";
    private List<BaseTour> list = new ArrayList<BaseTour>();
    private static Properties pr = new Properties();

    public enum TableNames{
        SHOPPINGS("shoppings"), CRUISES("cruises"), EXCURSIONS("excursions");

        String tableName;

        TableNames(String tableName){
            this.tableName = tableName;
        }

        public String getTableName() {
            return tableName;
        }
    }


    public DatabaseWorker() {

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
    }

    public static void createConnection(){
        try {
            Class.forName(driverName);
            System.out.println("OK! Driver is registered! ");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql JDBC driver not found");
        }

        try {
            c = DriverManager.getConnection(databaseURL+"tours", user, password);
            System.out.println("Connect");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }

    public static void closeConnection() {
         try {
            if (c != null)
                c.close();
        } catch (SQLException e) {
        }
    }



    @Override
    public List<BaseTour> readAll() {

        createConnection();

        FileChecker.prepareFile(DATABASE_PROPERTIES);

        TableNames[] tableNameList = TableNames.values();
        String query;
        PreparedStatement prState = null;
        ResultSet resSet = null;

        for( TableNames tableName : tableNameList ) {

            query = "SELECT * FROM " + tableName + "; ";

            try {
                prState = c.prepareStatement(query);
                resSet = prState.executeQuery();

                switch (tableName){
                    case SHOPPINGS:
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

                    case CRUISES:
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

                    case EXCURSIONS:
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
        closeConnection();
        return list;
    }

/*    @Override
    public List<BaseTour> readAll(String EMPLOYEE_INFO_TXT) {
        return null;
    }*/

    @Override
    public void addNewTour(String[] param){

        try {

            TableNames table = null;
            for(TableNames tableName : TableNames.values()){
                if(tableName.getTableName().equals(param[1])){
                    table = tableName;
                    break;
                }
            }

            switch (table){
                case SHOPPINGS:
                    addNewShopping(param);
                    break;
                case CRUISES:
                    addNewCruise(param);
                    break;
                case EXCURSIONS:
                    addNewExcursion(param);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewShopping(String[] str) {

        createConnection();

        Shopping tour = new Shopping();

        tour.setId(null);
        tour.setTypeDesc(str[1]);
        tour.setFood(str[2]);
        tour.setTransport(str[3]);
        tour.setDuration(Integer.parseInt(str[4]));
        tour.setPrice(Double.parseDouble(str[5]));
        tour.setCountry(str[6]);
        tour.setNightTransfer(str[7]);

        String query;
        PreparedStatement prState = null;

        query = "INSERT INTO "+ TableNames.SHOPPINGS.getTableName() +" (`id`,`type`, `food`, `transport`, `duration`, `price`, `country`, `nighttransfer`) " +
                "VALUES ('" + tour.getId() + "','"+ tour.getTypeDesc() + "','" +tour.getFood() + "','" + tour.getTransport() + "','" + tour.getDuration() +
                "','" + tour.getPrice() + "','" + tour.getCountry() + "','" + tour.getNightTransfer() + "');";

        try {
            prState = c.prepareStatement(query);
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
            closeConnection();
        }
    }

    public void addNewCruise(String[] str){

        createConnection();

        Cruise tour = new Cruise();

        tour.setId(null);
        tour.setTypeDesc(str[1]);
        tour.setFood(str[2]);
        tour.setTransport(str[3]);
        tour.setDuration(Integer.parseInt(str[4]));
        tour.setPrice(Double.parseDouble(str[5]));
        tour.setCountries(Arrays.asList(str[6]));

        String query;
        PreparedStatement prState = null;

        query = "INSERT INTO "+ TableNames.CRUISES.getTableName() +" (`id`,`type`, `food`, `transport`, `duration`, `price`, `countries`) " +
                "VALUES ('" + tour.getId() + "','"+ tour.getTypeDesc() + "','" +tour.getFood() + "','" + tour.getTransport() + "','" + tour.getDuration() +
                "','" + tour.getPrice() + "','" + tour.getCountries() + "');";

        try {
            prState = c.prepareStatement(query);
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
            closeConnection();
        }
    }

    public void addNewExcursion(String[] str){

        createConnection();

        Excursion tour = new Excursion();

        tour.setId(null);
        tour.setTypeDesc(str[1]);
        tour.setFood(str[2]);
        tour.setTransport(str[3]);
        tour.setDuration(Integer.parseInt(str[4]));
        tour.setPrice(Double.parseDouble(str[5]));
        tour.setCountry(str[6]);
        tour.setDestination(Arrays.asList(str[7]));

        String query;
        PreparedStatement prState = null;

        query = "INSERT INTO "+ TableNames.EXCURSIONS.getTableName() +" (`id`,`type`, `food`, `transport`, `duration`, `price`, `country`, `destinations`) " +
                "VALUES ('" + tour.getId() + "','"+ tour.getTypeDesc() + "','" +tour.getFood() + "','" + tour.getTransport() + "','" + tour.getDuration() +
                "','" + tour.getPrice() + "','" + tour.getCountry() + "','" + tour.getDestination() + "');";

        try {
            prState = c.prepareStatement(query);
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
            closeConnection();
        }
    }

    @Override
    public void removeTour(String[] str) {

        createConnection();

        String query;
        PreparedStatement prState = null;
        String tableName = "";
        String typeDesc = str[0];
        int id = Integer.parseInt(str[1]);

        switch(typeDesc){
            case "Shopping":
                tableName = "shoppings";
                break;
            case "Cruise":
                tableName = "cruises";
                break;
            case "Excursion":
                tableName = "excursions";
                break;
            default:
                break;
        }

        query = "DELETE FROM " + tableName + " WHERE id = " + id + ";";

        try {
            prState = c.prepareStatement(query);
            prState.executeUpdate();
            System.out.println("Deletion finished. \n");
            new DatabaseWorker();
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
            closeConnection();
        }
    }
}