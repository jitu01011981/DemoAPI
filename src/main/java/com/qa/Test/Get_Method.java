package com.qa.Test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.utils.TestUtils;

public class Get_Method extends TestBase 
{
	TestBase testbase;
	String serviceUrl;
	String apiURL;
	String URL;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;


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
		closeableHttpResponse=restClient.get(URL);
		
		//status
		int status_code=closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(status_code);
		Assert.assertEquals(status_code, RESPONCE_STATUS_200,"Status code is not 200");
		
		String ResponceString=EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responceJason= new JSONObject(ResponceString);
		System.out.println("Json Responce from API: "+responceJason);
		
		//per_page
		String perPageValue = TestUtils.getValueByJPath(responceJason, "/per_page");
		System.out.println("Per Page Value is:"+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		//total
		String totalValue = TestUtils.getValueByJPath(responceJason, "/total");
		System.out.println("Total Value is:"+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		String lastname= TestUtils.getValueByJPath(responceJason, "/data[0]/last_name");
		String ID= TestUtils.getValueByJPath(responceJason, "/data[0]/id");
		String Avatar= TestUtils.getValueByJPath(responceJason, "/data[0]/avatar");
		String FirstName= TestUtils.getValueByJPath(responceJason, "/data[0]/first_name");

		System.out.println("Last Name:"+lastname);
		System.out.println("Last Name:"+FirstName);
		System.out.println("Last Name:"+ID);
		System.out.println("Last Name:"+Avatar);


		
		Header[] headerArray= closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allHeaders = new HashMap<String,String>();
		for(Header header:headerArray)
		{
			allHeaders.put(header.getName(), header.getValue());
			
		}
		System.out.println("Headers Key and Value:"+allHeaders);
		
		


	}

}
