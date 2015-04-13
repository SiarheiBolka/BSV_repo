package com.epam.cdp.byta2015.module3.lecture2.tourist.datareaders;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;
import com.epam.cdp.byta2015.module3.lecture2.tourist.parcer.OfferSAXParser;

public class XMLFileReader extends AbstractReader {

	private String fullPath;

	public XMLFileReader(String fullPath) {
		super();
		this.fullPath = fullPath;
	}

	@Override
	public Offer readInfo(int id) {
		Offer offer = null;
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		SAXParser sp;
		OfferSAXParser handler = null;
		try {
			sp = spfac.newSAXParser();
			handler = new OfferSAXParser();
			sp.parse(new File(fullPath), handler);
			offer = handler.getEmployeeById(id);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Parsing fails: " + e.getMessage());
		}
		return offer;
	}
}
