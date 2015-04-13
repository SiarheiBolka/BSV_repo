package com.epam.cdp.byta2015.tourist.datareaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.parsers.TourSAXParser;

public class XmlFileReader extends AbstractReader{

	private String fullPath;
	
	public XmlFileReader(String fullPath) {
		super();
		this.fullPath = fullPath;
	}
	
	List<BaseTour> list = new ArrayList<BaseTour>();
	@Override
	public List<BaseTour> readInfo() {
		//List<BaseTour> tour = null;
		
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		SAXParser sp;
		TourSAXParser handler = null;
		try {
			sp = spfac.newSAXParser();
			handler = new TourSAXParser();
			sp.parse(new File(fullPath), handler);
			list = handler.getListOfTours();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Parsing fails: " + e.getMessage());
		}
		
		return list;
	}
		/*
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		SAXParser sp;
		TourSAXParser handler = null;
		
		try {
			sp = spfac.newSAXParser();
			handler = new TourSAXParser();
			sp.parse(new File(fullPath), handler);
			tour = handler.getTour();
		} catch (Exception e) {
			System.out.println("Parsing fails: " + e.getMessage());
		}
		*/
	
}