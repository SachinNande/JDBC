package com.sachin.practice.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.mysql.jdbc.Driver;

public class MyThirdjdbc {

	public static void main(String[] args) 
	{
		Connection con =null;
		PreparedStatement pstmt = null;
		try
		{
			
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl ="jdbc:mysql://localhost:3306/bejm32";
			con = DriverManager.getConnection(dburl, "root", "root");
			
			
			String query = " delete from studentinfo "
					+" where ( regno = ? ) ";
			 pstmt = con.prepareStatement(query);
			 pstmt.setInt(1, Integer.parseInt(args[0]));
			 
			 int res = pstmt.executeUpdate();
			 if(res!=0)
			 {
				 System.out.println("Record Deleted Successfully..");
			 }
			
		} 
		
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		finally
		{
			
			
				try 
				{
					if(con!=null)
					{
						con.close();
					}
					
					
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			
		}

	}

}
