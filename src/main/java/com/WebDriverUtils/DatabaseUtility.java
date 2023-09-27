package com.WebDriverUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con = null;
	
	/**
	 * THis is method is used to connect Database
	 * @author Vijayalaxmi
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathconstants.dbURL, IPathconstants.dbUSERNAME, IPathconstants.dbPASSWORD);
	
	}
	
	/**
	 * This method hiii is used to execute query and get the data
	 * @author Vijayalaxmi
	 * @param query
	 * @param columnNo
	 * @param ExpData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, int columnNo, String ExpData) throws SQLException
	{
		
		
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String data = result.getString(columnNo);
			if(data.equalsIgnoreCase(ExpData))
			{
				flag =true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("-- Data is Varified");
			return ExpData;
		}
		else
		{
			System.out.println("-- Data is not present");
			return "";
		} 
		
	}
	
	/**
	 * This method is used close Database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}

	public void getDBConnect() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathconstants.dbURL, IPathconstants.dbUSERNAME, IPathconstants.dbPASSWORD);	
		
	}
	
		

}
