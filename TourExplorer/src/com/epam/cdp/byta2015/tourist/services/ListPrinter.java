package com.epam.cdp.byta2015.tourist.services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.services.Printer;

import java.util.List;


public class ListPrinter implements Printer {

    public void print(List<BaseTour> list) {

        try {
            System.out.println("\nList of available tours:");
                for(BaseTour baseTour : list){
                    System.out.println(baseTour.getInfo());
                }
            System.out.println("\n");
        }
        catch (NullPointerException e) {
            System.out.println("Error: no tours available!\n");
        }

    }

}
