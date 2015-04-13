package com.epam.cdp.byta2015.tourist.datareaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;

public class TxtFileReader extends AbstractReader {

	private String fullPath;

	public TxtFileReader(String fullPath) {
		super();
		this.fullPath = fullPath;
	}
	
	@Override
	public List<BaseTour> readInfo() {

		File f = new File(getFullPath());
		BufferedReader br = null;
		String str = null;
		List<BaseTour> list = new ArrayList<BaseTour>();
				
		try {
			br = new BufferedReader(new FileReader(f));
			int iter = 0;
			
			while ((str = br.readLine()) != null) {
				iter++;
				String[] info = str.split(": ");
				
				if(info.length == 7) {
					
					String[] countries = info[6].split(",");
					List<String> countriesList = new ArrayList<String>();
					int counter = 0;
					
					while (countries.length> counter) {
						countriesList.add(countries[counter]);
						counter++;
					}
					
					Cruise cruise = new Cruise(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]),Double.parseDouble(info[5]), countriesList);
					list.add(cruise);
					
				} else if ((info.length == 8) && ((info[7]).contentEquals("Y") == true || (info[7]).contentEquals("N") == true)) {
					Shopping shopping = new Shopping(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]), Double.parseDouble(info[5]), info[6], info[7]);
					list.add(shopping);

				} else if ((info.length == 8) && ((info[7]).length() > 1)) {
					String[] destinations = info[7].split(",");
					List<String> destinationsList = new ArrayList<String>();
					int counter = 0;
					
					while (destinations.length> counter) {
						destinationsList.add(destinations[counter]);
						counter++;
					}
					Excursion excursion = new Excursion(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]),Double.parseDouble(info[5]), info[6], destinationsList);
					list.add(excursion);

				} else {
					System.out.println("Error during reading txt file!");
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

		return list;
	}
	
	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
}
