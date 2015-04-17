package com.epam.cdp.byta2015.tourist.datareaders;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.services.FileChecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TxtFileReader implements Reader {

    private static final String EMPLOYEE_INFO_TXT = "catalog.txt";
    private List<BaseTour> list;
    //private String fullPath;

    @Override
    public List<BaseTour> readAll() {

        FileChecker.checkFile(EMPLOYEE_INFO_TXT);

        File txtFile = new File(EMPLOYEE_INFO_TXT);
        BufferedReader br = null;
        String stringBuffer = null;
        List<BaseTour> list = new ArrayList<BaseTour>();

        try {
            br = new BufferedReader(new FileReader(txtFile));

            int iter = 0;

            while ((stringBuffer = br.readLine()) != null) {
                iter++;
                String[] info = stringBuffer.split(": ");

                if (info[1].equals("Cruise")) {

                    String[] countries = info[6].split(",");
                    List<String> countriesList = new ArrayList<String>();

                    countriesList = Arrays.asList(countries);
                    Cruise cruise = new Cruise(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]), Double.parseDouble(info[5]), countriesList);
                    list.add(cruise);

                } else if (info[1].equals("Shopping")) {
                    Shopping shopping = new Shopping(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]), Double.parseDouble(info[5]), info[6], info[7]);
                    list.add(shopping);

                } else if (info[1].equals("Excursion")) {
                    String[] destinations = info[7].split(",");
                    List<String> destinationsList = new ArrayList<String>();

                    destinationsList = Arrays.asList(destinations);
                    Excursion excursion = new Excursion(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]), Double.parseDouble(info[5]), info[6], destinationsList);
                    list.add(excursion);

                } else {
                    System.out.println("Error during reading txt file!");
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return list;
    }
}