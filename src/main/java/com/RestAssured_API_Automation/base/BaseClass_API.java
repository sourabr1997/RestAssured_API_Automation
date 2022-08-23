/**
 * 
 */
package com.RestAssured_API_Automation.base;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.RestAssured_API_Automation.utility.ExtentManager_API;
import com.RestAssured_API_Automation.utility.Log4j_API;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author ravindrs
 *
 */
public class BaseClass_API {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	
	
	@BeforeSuite 
	public void loadConfig() throws IOException {
		ExtentManager_API.setExtent();
		DOMConfigurator.configure("log4j.xml");
		Log4j_API.info("This is beforeSuite Method");
		
	}
	
	
	
	
	@AfterSuite (groups = {"Smoke", "Sanity", "Regression"})
	public void afterSuite1() throws IOException {
		Log4j_API.info("This is afterSuite Method");
		ExtentManager_API.endReport();
	}



}
