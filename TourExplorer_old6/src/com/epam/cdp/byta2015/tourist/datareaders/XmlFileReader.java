package com.epam.cdp.byta2015.tourist.datareaders;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.parsers.TourSAXParser;
import com.epam.cdp.byta2015.tourist.services.FileChecker;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class XmlFileReader implements Reader{

    private static final String EMPLOYEE_INFO_XML = "catalog.xml";
    List<BaseTour> list;
    //private String fullPath;

    /*public XmlFileReader() {
        this.fullPath = EMPLOYEE_INFO_XML;
    }*/

    @Override
    public List<BaseTour> readAll() {

        FileChecker.checkFile(EMPLOYEE_INFO_XML);

        XmlFileReader xmlReader = new XmlFileReader();

        SAXParserFactory spfac = SAXParserFactory.newInstance();
        SAXParser sp;
        TourSAXParser handler = null;

        try {
            sp = spfac.newSAXParser();
            handler = new TourSAXParser();
            sp.parse(new File(EMPLOYEE_INFO_XML), handler);
            list = handler.getList();
        } catch (Exception e) {
            System.out.println("Parsing fails: " + e.getMessage());
        }

        return list;
     }
}
