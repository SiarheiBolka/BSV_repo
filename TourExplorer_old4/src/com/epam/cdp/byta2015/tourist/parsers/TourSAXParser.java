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

    private BaseTour tour = new BaseTour();
    private Shopping shopping = new Shopping();
    private Cruise cruise = new Cruise();
    private Excursion excursion = new Excursion();

    private List<BaseTour> list = new ArrayList<BaseTour>();

    private StringBuilder thisElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML document with Employees Info...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = new StringBuilder();
        if (qName.equals("shopping")) {
            list = new ArrayList<BaseTour>();
//            shopping = new Shopping();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
             if (qName.equals("shopping")) {
                System.out.println(list.size());
                list.add(shopping);
            } else {
                    String elementVal = thisElement.toString();
                 if (qName.equals("id")) {
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

        thisElement = new StringBuilder();;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        thisElement.append(ch, start, length);
    }

    public List<BaseTour> getList() {
        return list;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Stop parse XML document with Employees Info...");
    }

}
