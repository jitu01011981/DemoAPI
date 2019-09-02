package com.qa.Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class Get_Method extends TestBase {
	
	TestBase testbase;
	String serviceUrl;
	String apiURL;
	String URL;
	RestClient restClient;

	@BeforeMethod
	public void setup() throws Throwable, Throwable
	{
		testbase = new TestBase();
		apiURL = prop.getProperty("ApiURL");
		serviceUrl = prop.getProperty("serviceURL");
		
		URL=apiURL+serviceUrl;
		
	}

	@Test
	public void getAPI() throws Throwable, Throwable
	{
		restClient= new RestClient();
		restClient.get(URL);

	}

}
