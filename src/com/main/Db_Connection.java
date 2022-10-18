package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Connection {

	
	public Connection getConnection() throws ClassNotFoundException,SQLException 
	{
		Connection connection=null;	
		try 
		{
			  
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","7722");
			 
		}
		 catch(SQLException e) 
		  {
		   System.out.println("database not connected: " +e);
		  }
	
		return connection;
	}
}

