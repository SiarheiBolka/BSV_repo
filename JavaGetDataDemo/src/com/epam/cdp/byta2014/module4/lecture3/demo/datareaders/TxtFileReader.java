package com.epam.cdp.byta2014.module4.lecture3.demo.datareaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.epam.cdp.byta2014.module4.lecture3.demo.model.Employee;

public class TxtFileReader extends AbstractReader {

	private String fullPath;

	public TxtFileReader(String fullPath) {
		super();
		this.fullPath = fullPath;
	}

	@Override
	public Employee readInfo(int id) {
		File f = new File(getFullPath());
		BufferedReader br = null;
		String str = null;
		Employee employee = null;
		try {
			br = new BufferedReader(new FileReader(f));

			while ((str = br.readLine()) != null) {
				String[] info = str.split(":");
				if (Integer.parseInt(info[0]) == id) {
					employee = new Employee(Integer.parseInt(info[0]), info[1],	info[2], Double.parseDouble(info[3]));
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		return employee;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

}
