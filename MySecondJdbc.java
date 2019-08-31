package com.sachin.practice.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class MySecondJdbc {

	public static void main(String[] args) throws SQLException
	{
		Connection con=null;
		PreparedStatement pstmt =null;
		try 
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			
			
			String dburl = "jdbc:mysql://localhost:3306/bejm32";
			con = DriverManager.getConnection(dburl, "root", "root");
			
			String query = " insert into studentinfo "
					+ " values(?,?,?,?) ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setString(3, args[2]);
			pstmt.setString(4,args[3]);
			
			int res = pstmt.executeUpdate();
			 if(res!=0)
			 {
				 System.out.println("record inserted Successfully...");
			 }
			

			
		} catch (Exception e)
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
			catch (Exception e) 
			{
				e.printStackTrace();
				
			}
		}
		
				
	}

}
