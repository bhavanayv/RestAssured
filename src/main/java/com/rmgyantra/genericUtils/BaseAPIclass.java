package com.rmgyantra.genericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;
/**
 * this is the base api class
 * @author Admin
 *
 */
public class BaseAPIclass {
	public DataBaseUtility dbUtil=new DataBaseUtility();

	@BeforeSuite
	public void connectToDB() {
		System.out.println("----start----");
		dbUtil.connectDB();
		System.out.println("DB connection is established");
		baseURI =  "http://localhost";
		port= 8084;
	}

	@AfterSuite
	public void closingDBconnection() {
		dbUtil.closeDB();
		System.out.println("DB connection is closed");
	}
}
