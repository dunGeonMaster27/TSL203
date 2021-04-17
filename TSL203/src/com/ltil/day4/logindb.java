package com.ltil.day4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class logindb {
	public static void main (String[]args)
	{
	      try {
		Connection conn = ConnectionManager.getConnection();
		  Statement stmt = conn.createStatement();

	      String sql = "SELECT username,password from login";
	
			ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next()){
		         //Retrieve by column name
		         String username = rs.getString("username");
		         String password = rs.getString("password");

		         //Display values

		         System.out.print("username: " + username);
		         System.out.println(",password: " + password);
		      }
		      rs.close();
	      } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	 
	
	
	
}
