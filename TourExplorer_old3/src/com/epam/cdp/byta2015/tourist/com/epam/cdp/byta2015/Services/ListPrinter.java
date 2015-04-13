package com.epam.cdp.byta2015.tourist.com.epam.cdp.byta2015.Services;

import com.epam.cdp.byta2015.tourist.model.BaseTour;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siarhei_Bolka on 4/8/2015.
 */
public class ListPrinter {
    List<BaseTour> list = new ArrayList<BaseTour>();

    public static void printAvailableTours(List<BaseTour> list) {
        System.out.println("\nList of available offers:");
        if (list.size() != 0) {
            for(BaseTour baseTour : list){
                System.out.println(baseTour.getInfo());
            }
        } else {
            System.out.println("Error: no offers available!");
        }

        System.out.println("\n");
    }

}
