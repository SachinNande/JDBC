package com.sachin.practice.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class CreateTable {

	public static void main(String[] args)
	{
		PreparedStatement pstmt =null;
		Connection con=null;
		try
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/mock";
			con = DriverManager.getConnection(dburl, "root", "root");
			
			
			String query = " create table student "
					+" ( id int(10) ,"
					+ "User_id varchar(10) NOT NULL , "
					+ " Password varchar(10) NOT NULL ) ";
			
		pstmt =con.prepareStatement(query);
		int res = pstmt.executeUpdate();
		if(res!=0)
		{
			System.out.println("table created...");
		}
		System.out.println("table has been created..");
			
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
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		

	}

}
