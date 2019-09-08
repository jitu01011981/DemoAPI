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
	
	public CloseableHttpResponse get(String url) throws Throwable, IOException
	{
		
	CloseableHttpClient httpClient = HttpClients.createDefault();
	
	System.out.println(url);
	HttpGet httpget = new HttpGet(url); //http get request
	CloseableHttpResponse  closeableHttpResponse= httpClient.execute(httpget);//hit the url
	
	return closeableHttpResponse;
	}
	
}
