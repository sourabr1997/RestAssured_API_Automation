/**
 * 
 */
package com.RestAssured_API_Automation.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



/**
 * @author ravindrs
 *
 */
public class ExtentManager_API {
	public static ExtentSparkReporter htmlReporter; // latest change ExtentSparkReporter 
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException {
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config_API.xml");
		htmlReporter.config().setDocumentTitle("API Automation Test Report");
		htmlReporter.config().setReportName("API Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK); 
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "API Automation testing");
		extent.setSystemInfo("Tester", "Sourab");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	public static void endReport() {
		extent.flush();
		
	}

}
