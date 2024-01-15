package com.jsp.jdbc_prepared_statement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class LaptopConnection {
	
	public static Connection getLaptopConnection(){
		
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			String url="jdbc:mysql://localhost:3306/Laptop";
			String user="root";
	      	String pass="Rahul@325";
	      	
	      	return DriverManager.getConnection(url,user,pass);
	      	
	      	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;

		
	}
}
