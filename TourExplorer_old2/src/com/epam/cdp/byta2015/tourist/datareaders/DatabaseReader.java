package com.epam.cdp.byta2015.tourist.datareaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;

public class DatabaseReader extends AbstractReader {


	private Connection connection;
	private String db;
	
	public DatabaseReader(Connection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public List<BaseTour> readInfoFromFirstDB() {
		PreparedStatement prState = null;
		ResultSet rs = null;
		
		List<BaseTour> list = new ArrayList<BaseTour>();
		
		try {
			prState = getConnection().prepareStatement("SELECT * FROM shoppings;"); 
			
			rs = prState.executeQuery();
						
			while(rs.next()){
				Shopping tour = new Shopping(rs.getInt("id"), rs.getString("type"), rs.getString("food"), rs.getString("transport"), rs.getInt("duration"), rs.getDouble("price"), rs.getString("country"), rs.getString("nighttransfer"));
				list.add(tour);
			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {}
			try {
				if (prState != null)
					prState.close();
			} catch (SQLException e) {}
		}
		return list;
	}

	@Override
	public List<BaseTour> readInfoFromSecondDB() {
		PreparedStatement prState = null;
		ResultSet rs = null;
		
		List<BaseTour> list = new ArrayList<BaseTour>();
		
		try {
			prState = getConnection().prepareStatement("SELECT * FROM cruises;"); 
			
			rs = prState.executeQuery();
						
			while(rs.next()){
				String[] countries = rs.getString("countries").split(", ");
				
				List<String> countriesList = new ArrayList<String>();
				int counter = 0;
				
				while (countries.length> counter) {
					countriesList.add(countries[counter]);
					counter++;
				}
				
				Cruise tour = new Cruise(rs.getInt("id"), rs.getString("type"), rs.getString("food"), rs.getString("transport"), rs.getInt("duration"), rs.getDouble("price"), countriesList);
				list.add(tour);
			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {}
			try {
				if (prState != null)
					prState.close();
			} catch (SQLException e) {}
		}
		
		return list;
	}
		
		@Override
		public List<BaseTour> readInfoFromThirdDB() {
			PreparedStatement prState = null;
			ResultSet rs = null;
			
			List<BaseTour> list = new ArrayList<BaseTour>();
			
			try {
				prState = getConnection().prepareStatement("SELECT * FROM excursions;"); 
				
				rs = prState.executeQuery();
							
				while(rs.next()){
					String[] destinations = rs.getString("destination").split(", ");
					
					List<String> destinationsList = new ArrayList<String>();
					int counter = 0;
					
					while (destinations.length> counter) {
						destinationsList.add(destinations[counter]);
						counter++;
					}
					
					Excursion tour = new Excursion(rs.getInt("id"), rs.getString("type"), rs.getString("food"), rs.getString("transport"), rs.getInt("duration"), rs.getDouble("price"), rs.getString("country"), destinationsList);
					list.add(tour);
				}
					
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (SQLException e) {}
				try {
					if (prState != null)
						prState.close();
				} catch (SQLException e) {}
			}
		
		return list;
	}
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
