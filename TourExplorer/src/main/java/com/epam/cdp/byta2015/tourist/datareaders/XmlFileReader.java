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


    @Override
    public List<BaseTour> readAll() {

        List<BaseTour> list = new ArrayList<>();

        FileChecker.checkFile(EMPLOYEE_INFO_XML);

        //Create a "parser factory" for creating SAX parsers
        SAXParserFactory spfac = SAXParserFactory.newInstance();

        //Create an instance of this class; it defines all the handler methods
        TourSAXParser handler = new TourSAXParser();

        try {
            //Now use the parser factory to create a SAXParser object
            SAXParser sp = spfac.newSAXParser();
            //Finally, tell the parser to parse the input and notify the handler
            sp.parse(new File(EMPLOYEE_INFO_XML), handler);
            list = handler.getList();
        } catch (Exception e) {
            System.out.println("Parsing fails: " + e.getMessage());
        }

        return list;
     }
}
