package com.jspiders.jdbc.mock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertRecordTable1 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try 
		{
			/*
			 * load and register the driver
			 * */
			Object obj= Class.forName("com.mysql.jdbc.Driver").newInstance();
			Driver driverref = (Driver)obj;
			DriverManager.registerDriver(driverref);
			
			/*establish the connection
			 * 
			 * */
			String dburl ="jdbc:mysql://localhost:3306/mock";
		con= 	DriverManager.getConnection(dburl, "root", "root");
		
		/*
		 * issue sql query...
		 * */
		
		String query = " insert into table_1 "
				+ " values (?,?) ";
		String query1 = " insert into table_2 "
				+ " values (?,?) ";
	    pstmt = con.prepareStatement(query);
		pstmt.setInt(1,Integer.parseInt(args[0])); /*  process the result....*/
		pstmt.setString(2, args[1]);
		
		 int res1 =pstmt.executeUpdate();
		 
		pstmt = con.prepareStatement(query1);
		pstmt.setInt(1,Integer.parseInt(args[0]));
		pstmt.setString(2, args[1]);
		
		int res= pstmt.executeUpdate();
		
		  
			if(res1!=0)
			{
				System.out.println("in table 1 record inserted successfully...");
			}
		
		if(res!=0)
		{
			System.out.println("in table 2record insertef successfully...");
		}
			
		} 
		catch (SQLException e)
		{
			System.out.println("the givent id is already present");
		}
		finally
		{
			/*
			 * close the conncetion
			 * */
			
				try {
					if(con!=null)
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
