package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQuery {

	public static void main(String[] args) throws Throwable {
		
	Connection con= null;
	
	try 
	{
		
		
		
		Driver driver = new Driver();
		
		//register the database
		
		DriverManager.registerDriver(driver);
		
		
		//get connection to the database
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		
		// create statement
		
		Statement state = con.createStatement();
		
		String query = "select * from tyss;";
		
		//execute query
		
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			
			System.out.println(result.getString(1)+"  "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			
			
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	}
	finally
	{
		con.close();
	}
	
	{
			
		}		
				
	}

}
