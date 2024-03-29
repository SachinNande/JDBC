package com.sachin.practice.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FirstJdbc {

	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		/*
		 * load and register the driver
		 */
		try {
			
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			
			/*
			 * established the connection with database.........
			 */
			String dburl = "jdbc:mysql://localhost:3306/bejm32?user=root&password=root";
			con =DriverManager.getConnection(dburl);
			
			/*
			 * process the sql query 
			 */
			
			String query = " select * from studentinfo ";
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(query);
			 while(rs.next())
			 {
				 int rN = rs.getInt("regno");
				 String fname = rs.getString("firstname");
				 String mname = rs.getString("middlename");
				 String lname = rs.getString("lastname");
				 
				 System.out.println("regno : "+ rN);
				 System.out.println("firstname : "+fname);
				 System.out.println("middlename : "+mname);
				 System.out.println("lastname : "+lname);
			 }
			
			
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		finally 
		{
			try {
				if(con!=null)
				 {
					 con.close();
				 }
				 if(stmt!=null)
				 {
					 stmt.close();
				 }
				 if(rs!=null)
				 {
					 rs.close();
				 }
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		 	
	}

}
