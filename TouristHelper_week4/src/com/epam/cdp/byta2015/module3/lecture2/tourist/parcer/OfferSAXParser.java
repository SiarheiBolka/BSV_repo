package com.epam.cdp.byta2015.module3.lecture2.tourist.parcer;

import java.util.LinkedList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;

public class OfferSAXParser extends DefaultHandler{

	private Offer offer;
	private LinkedList<Offer> offers = new LinkedList<Offer>();
	private StringBuilder thisElement;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parse XML document with Employees Info...");
	}
	
	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		thisElement = new StringBuilder();
		if (qName.equals("employee")) {
			offer = new Offer();
		}
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		if (qName.equals("employee")) {
			System.out.println(offer.toString());
			offers.add(offer);
		} else {
			String elementVal = thisElement.toString();		
			if (qName.equals("type")) {		
				offer.setTypeofTour(elementVal);
			} else if (qName.equals("transport")) {
				offer.setTransport(elementVal);
			} else if (qName.equals("food")) {
				offer.setFood(elementVal);
			} else if (qName.equals("days")) {
				offer.setDaysCount(Integer.parseInt(elementVal));
			} 
		}
		
		thisElement = new StringBuilder();;
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Stop parse XML document with Employees Info...");
		
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		thisElement.append(ch, start, length);			
	}
	
	//TODO change according Offer
	public Offer getOfferById(int id) {
		Offer result = null;
		for(Offer offer : offers){
			if(offer.getTypeofTour() == id) {
				result = offer;
			}
		}
		return result;
	}
	
}
