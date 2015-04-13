package com.epam.cdp.byta2015.module3.lecture2.tourist.datawriters;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;

public class TxtFileWriter extends AbstractWriter{

	private String fullPath;
	//private Offer offer;

	public TxtFileWriter(String fullPath) {
		super();
		this.fullPath = fullPath;
	}

	public void writeInfo(Offer offer) {
		File f = new File(getFullPath());
		BufferedWriter br = null;

		try {
			br = new BufferedWriter(new FileWriter(f, true));
			br.write("\n" + offer.getTypeofTour() + ": " + offer.getTransport() + ": " + offer.getFood() + ": " + offer.getDaysCount());
			//br.flush();
			br.close();
		} catch (IOException e) {
			System.out.println("Error during file writing: " + e);                           
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	
	}
	
	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	@Override
	public void writeInfo() {
		// TODO Auto-generated method stub
		
	}

}
