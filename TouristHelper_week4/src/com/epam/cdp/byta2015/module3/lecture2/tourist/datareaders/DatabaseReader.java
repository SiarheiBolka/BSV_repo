package com.epam.cdp.byta2015.module3.lecture2.tourist.datareaders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.cdp.byta2015.module3.lecture2.tourist.exceptions.InvalidReadDataException;
import com.epam.cdp.byta2015.module3.lecture2.tourist.model.Offer;

public class DatabaseReader extends AbstractReader{

	private Connection connection;
	
	public DatabaseReader(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public List<Offer> readInfo(int recordNumber) {
		PreparedStatement prState = null;
		ResultSet rs = null;
		
		List<Offer> list = new ArrayList<Offer>();
		Offer offer = null;
		
		try {
			//It says return one record starting at record n.
			prState = getConnection().prepareStatement("SELECT * FROM offer ORDER BY days LIMIT ?,1;"); 

			//prState = getConnection().prepareStatement("SELECT * from offer where days=?;");
			prState.setInt(1, recordNumber);
			
			rs = prState.executeQuery();
			while(rs.next()){
				offer = new Offer(rs.getString("type"), rs.getString("transport"), rs.getString("food"), rs.getInt("days"));
				list.add(offer);
				
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

	@Override
	public List<Offer> readInfo() throws InvalidReadDataException {
		// TODO Auto-generated method stub
		return null;
	}

}
