package com.sachin.practice.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class AddColumn {

	public static void main(String[] args)
	{
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/mock";
			con = DriverManager.getConnection(dburl, "root", "root");
			
			String query = " alter table student add column Marks integer(5) ";
		    pstmt = con.prepareStatement(query);
			int res = pstmt.executeUpdate();
			if(res!=0)
			{
				System.out.println("column has been added...");
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			
				try {
					if(con!=null)
					con.close();
				}
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			
		}
		
	}

}
