package com.rmgyantra.genericUtils;
/**
 * This class contains methods realted to database
 * @author Bhavana
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	public Connection connection=null;
	/**
	 * this method will establish database connection
	 */
	public void connectDB() {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
	}

	/**
	 * this method will close the database connection
	 */

	public void closeDB() {
		try {
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method will return the entire database	
	 * @param query
	 * @return
	 */

	public ResultSet getAllData(String query) {
		try {
			ResultSet result = connection.createStatement().executeQuery(query);
			return result;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * this method is used to verify the data from the database and return the value
	 * @param query
	 * @param column_num
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */

	public String getDataAndVerifyTheData(String query, int column_num, String expectedData) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(query);
		boolean flag=false;
		String actualData=null;
		try {
			while(result.next())
			{
				if(result.getString(column_num).equals(expectedData))
				{
					actualData= result.getString(column_num);
					flag=true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag==true)
		{
			System.out.println("data is verfied and matching");
			return actualData;
		}
		else
		{
			System.out.println("data is verfied and not matching");
			return actualData;
		}
	}
}
