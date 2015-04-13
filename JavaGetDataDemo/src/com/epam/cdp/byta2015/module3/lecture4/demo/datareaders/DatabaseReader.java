package com.epam.cdp.byta2015.module3.lecture4.demo.datareaders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.cdp.byta2015.module3.lecture4.demo.model.Employee;

public class DatabaseReader extends AbstractReader{

	private Connection connection;
	
	public DatabaseReader(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public Employee readInfo(int id) {
		PreparedStatement prState = null;
		ResultSet rs = null;
		
		Employee employee = null;
		
		try {
			prState = getConnection().prepareStatement("SELECT * from employee where id=?;");
			prState.setInt(1, id);
			
			rs = prState.executeQuery();
			while(rs.next()){
				if(rs.getInt("id") == id){
					employee = new Employee(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getDouble("salary"));
				}
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
		return employee;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	

}
