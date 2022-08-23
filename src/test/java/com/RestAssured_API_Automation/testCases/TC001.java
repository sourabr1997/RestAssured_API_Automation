/**
 * 
 */
package com.RestAssured_API_Automation.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured_API_Automation.base.BaseClass_API;
import com.RestAssured_API_Automation.utility.Log4j_API;

import io.restassured.RestAssured;
import io.restassured.http.Method;

/**
 * @author ravindrs
 *
 */
public class TC001 extends BaseClass_API {
	
	@BeforeClass
	public void getAllEmployees() throws InterruptedException {
		Log4j_API.info("**********Started TC001**********");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3000);
	}
	
	@Test
	public void checkResponseBody() {
		Log4j_API.info("**********Checking response body**********");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}
	

}
