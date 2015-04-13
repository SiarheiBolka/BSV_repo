package com.epam.cdp.byta2015.tourist.datareaders;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.parsers.TourSAXParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergik on 08.04.2015.
 */

public class XmlFileReader implements Reader{

    private static final String EMPLOYEE_INFO_XML = "catalog.xml";
    List<BaseTour> list;
    private String fullPath;

    public XmlFileReader() {this.fullPath = EMPLOYEE_INFO_XML;}

    @Override
    public List<BaseTour> readAll() {

        XmlFileReader xmlReader = new XmlFileReader();

        SAXParserFactory spfac = SAXParserFactory.newInstance();
        SAXParser sp;
        TourSAXParser handler = null;

        try {
            sp = spfac.newSAXParser();
            handler = new TourSAXParser();
            sp.parse(new File(fullPath), handler);
            list = handler.getList();
        } catch (Exception e) {
            System.out.println("Parsing fails: " + e.getMessage());
        }
        /*catch(NullPointerException ex) {
            System.out.println("Error during loading data from .xml file! ");
        }*/
        return list;
     }
}
