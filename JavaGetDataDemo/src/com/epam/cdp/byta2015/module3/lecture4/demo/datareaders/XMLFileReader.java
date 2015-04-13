package com.epam.cdp.byta2015.module3.lecture4.demo.datareaders;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.epam.cdp.byta2015.module3.lecture4.demo.model.Employee;
import com.epam.cdp.byta2015.module3.lecture4.demo.parcer.EmployeeSAXParser;

public class XMLFileReader extends AbstractReader {

	private String fullPath;
	
	public XMLFileReader(String fullPath) {
		super();
		this.fullPath = fullPath;
	}
	
	@Override
	public Employee readInfo(int id) {
		Employee employee = null;
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		SAXParser sp;
		EmployeeSAXParser handler = null;
		try {
			sp = spfac.newSAXParser();
			handler = new EmployeeSAXParser();
			sp.parse(new File(fullPath), handler);
			employee = handler.getEmployeeById(id);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Parsing fails: " + e.getMessage());
		}
		return employee;
	}
}
