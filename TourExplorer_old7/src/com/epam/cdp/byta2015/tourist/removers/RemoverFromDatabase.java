package com.epam.cdp.byta2015.tourist.removers;


import com.epam.cdp.byta2015.tourist.datareaders.DatabaseReader;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoverFromDatabase {

    public void removeShoppingFromDatabase () {
        String query;
        PreparedStatement prState = null;

        query = "DELETE FROM shoppings WHERE id = 4;";

        try {
            prState = DatabaseReader.c.prepareStatement(query);
            prState.executeUpdate();
            System.out.println("Deletion finished. Reload data from database to see the changes.\n");
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
