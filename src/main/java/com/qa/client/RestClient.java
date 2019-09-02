package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	public void get(String url) throws Throwable, IOException
	{
		
	CloseableHttpClient httpClient = HttpClients.createDefault();
	
	System.out.println(url);
	HttpGet httpget = new HttpGet(url); //http get request
	CloseableHttpResponse  closeableHttpResponse= httpClient.execute(httpget);//hit the url
	
	int status_code=closeableHttpResponse.getStatusLine().getStatusCode();
	System.out.println(status_code);
	
	String ResponceString=EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	JSONObject responceJason= new JSONObject(ResponceString);
	System.out.println("Json Responce from API: "+responceJason);
	
	Header[] headerArray= closeableHttpResponse.getAllHeaders();
	HashMap<String,String> allHeaders = new HashMap<String,String>();
	for(Header header:headerArray)
	{
		allHeaders.put(header.getName(), header.getValue());
		
	}
	System.out.println("Headers Key and Value:"+allHeaders);
	System.out.println("API is working");
	
	}

}
