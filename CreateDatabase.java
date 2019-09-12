package com.sachin.practice.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class CreateDatabase 
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt =null;
		try
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/";
			con = DriverManager.getConnection(dburl, "root", "root");
			
			String query = " create database University ";
			pstmt= con.prepareStatement(query);
			
			int res = pstmt.executeUpdate();
			if(res!=0)
			{
				System.out.println("database created...");
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
