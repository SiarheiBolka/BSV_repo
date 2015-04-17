package com.epam.cdp.byta2015.tourist.dataremovers;

import com.epam.cdp.byta2015.tourist.datareaders.DatabaseReader;
import com.epam.cdp.byta2015.tourist.datareaders.Reader;
import com.epam.cdp.byta2015.tourist.runner.Runner;
import com.epam.cdp.byta2015.tourist.services.ListPrinter;
import com.epam.cdp.byta2015.tourist.services.Printer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoverFromDatabase implements Remover {

    @Override
    public void removeTour(String[] str) {

        Reader reader = Runner.getReader();
        Printer pr = new ListPrinter();
        String query;
        PreparedStatement prState = null;
        String tableName = "";
        String typeDesc = str[0];
        int id = Integer.parseInt(str[1]);

        switch (typeDesc) {
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
            prState = DatabaseReader.DatabaseReader().prepareStatement(query);
            prState.executeUpdate();
            System.out.println("Deletion finished. \n");
            new DatabaseReader();
            pr.print(Runner.getList());
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
