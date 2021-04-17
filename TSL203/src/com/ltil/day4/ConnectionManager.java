
package com.ltil.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection=null;
	
	private ConnectionManager()
	{}
	public static Connection getConnection()
	{
		if(connection==null) {
	try
	{
		//1st step load the driver class into the jvm
		
Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.Get Connection object
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		connection=DriverManager.getConnection(url, "hr", "hr");
		System.out.println(connection);
		}
		catch(ClassNotFoundException  cnf)
		{
			System.out.println(cnf.getMessage());
		}
		catch(SQLException sq)
		{
			System.out.println(sq.getMessage());
		}
	}
		return connection;
	}
	
	
}
