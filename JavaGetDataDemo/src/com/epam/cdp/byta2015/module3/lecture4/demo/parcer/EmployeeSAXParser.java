package com.epam.cdp.byta2015.module3.lecture4.demo.parcer;

import java.util.LinkedList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.cdp.byta2015.module3.lecture4.demo.model.Employee;

public class EmployeeSAXParser extends DefaultHandler{

	private Employee employee;
	private LinkedList<Employee> employees = new LinkedList<Employee>();
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
			employee = new Employee();
		}
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		if (qName.equals("shopping")) {
			System.out.println(shopping.toString());
			list.add(employee);
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
		System.out.println("Stop parse XML document with Employees Info...");
		
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		thisElement.append(ch, start, length);			
	}
	
	public Employee getEmployeeById(int id) {
		Employee result = null;
		for(Employee employee : employees){
			if(employee.getId() == id) {
				result = employee;
			}
		}
		return result;
	}
	
}
