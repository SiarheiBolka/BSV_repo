package com.epam.cdp.byta2015.tourist.parsers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.cdp.byta2015.tourist.model.BaseTour;


public class TourSAXParser extends DefaultHandler {
	
	private BaseTour tour = null;
	private List<BaseTour> list = new ArrayList<BaseTour>();
	private StringBuilder thisElement;
	
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parse XML document with Employees Info...");
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		if (qName.equals("employee")) {
			System.out.println(tour.toString());
			list.add(tour);
		} else {
			String elementVal = thisElement.toString();		
			if (qName.equals("id")) {		
				employee.setId(Integer.parseInt(elementVal));
			} else if (qName.equals("fname")) {
				employee.setFirstName(elementVal);
			} else if (qName.equals("lname")) {
				employee.setLastName(elementVal);
			} else if (qName.equals("salary")) {
				employee.setSalary(Double.parseDouble(elementVal));
			} 
		}
		
		thisElement = new StringBuilder();;
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Stop parse XML document with Tour Info...");
		
	}


}
