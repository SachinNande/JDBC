package com.sachin.practice.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class UpdateTable {

	public static void main(String[] args) 
	{
		PreparedStatement pstmt = null;
		Connection con = null;
		
	
		try 
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/mock";
			con = DriverManager.getConnection(dburl, "root","root");
			
			String query =" update student set User_id = ? where id = ? ";
			
			
			
			pstmt =con.prepareStatement(query);
			
			pstmt.setString(1, args[0]);
			pstmt.setInt(2, Integer.parseInt(args[1]));
			
			
			int res = pstmt.executeUpdate();
			if(res!=0)
			{
				System.out.println("Record updated...");
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					if(con!=null)
					{
						con.close();
					}
					
				} catch (Exception e2) 
				{
					e2.printStackTrace();
				}
			}
	
}
}

			


