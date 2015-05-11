package com.epam.cdp.byta2015.tourist.parsers;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergik on 09.04.2015.
 */
public class TourSAXParser extends DefaultHandler {

    //List to hold Tour object
    private List<BaseTour> list = new ArrayList<BaseTour>();
    private Shopping shopping = new Shopping();

    private BaseTour tour = new BaseTour();
    private Cruise cruise = new Cruise();
    private Excursion excursion = new Excursion();


    boolean inShopping = false;
    boolean inCruise = false;
    boolean inExcursion = false;

    //getter method for tours list
    public List<BaseTour> getList() {
        return list;
    }

    private StringBuilder thisElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML document with Employees Info...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = new StringBuilder();
        if (qName.equals("shopping")) {
            shopping = new Shopping();
            boolean inShopping = true;
        } else if (qName.equals("cruise")) {
            cruise = new Cruise();
            boolean inCruise = true;
        } else if (qName.equals("excursion")) {
            excursion = new Excursion();
            boolean inExcursion = true;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {

        if (qName.equals("shopping")) {
            inShopping = false;
            list.add(shopping);
        } else if (inShopping == true) {
            String elementVal = thisElement.toString();

            if (qName.equals("id") ) {
                shopping.setId(Integer.parseInt(elementVal));
            } else if (qName.equals("typeDesc")) {
                shopping.setTypeDesc(elementVal);
            } else if (qName.equals("food")) {
                shopping.setFood(elementVal);
            } else if (qName.equals("transport")) {
                shopping.setTransport(elementVal);
            } else if (qName.equals("duration")) {
                shopping.setDuration(Integer.parseInt(elementVal));
            } else if (qName.equals("price")) {
                shopping.setPrice(Double.parseDouble(elementVal));
            } else if (qName.equals("country")) {
                shopping.setCountry(elementVal);
            } else if (qName.equals("nightTransfer")) {
                shopping.setNightTransfer(elementVal);
            }
        }
/*
        if (qName.equals("cruise") && inCruise == true) {
            list.add(cruise);
        } else if (inCruise == true) {
            String elementVal = thisElement.toString();

            if (qName.equals("id") ) {
                cruise.setId(Integer.parseInt(elementVal));
            } else if (qName.equals("typeDesc")) {
                cruise.setTypeDesc(elementVal);
            } else if (qName.equals("food")) {
                cruise.setFood(elementVal);
            } else if (qName.equals("transport")) {
                cruise.setTransport(elementVal);
            } else if (qName.equals("duration")) {
                cruise.setDuration(Integer.parseInt(elementVal));
            } else if (qName.equals("price")) {
                cruise.setPrice(Double.parseDouble(elementVal));
            } else if (qName.equals("countries")) {
                shopping.setCountry(elementVal);

        }
*/
        thisElement = new StringBuilder();;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        thisElement.append(ch, start, length);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Stop parse XML document with Employees Info...");
    }

}
