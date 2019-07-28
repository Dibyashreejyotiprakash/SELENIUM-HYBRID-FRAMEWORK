package com.hybridprofinal.filereader;

import java.io.FileInputStream;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonParser;

public class JsonReader {
	
	
	
	public void ReadJosnData()
	{
		try
		{
			JSONParser parser = new JSONParser();
		    Object obj = parser.parse(new FileReader("./src/main/resources/JsonTestData/testdata.json"));
		    JSONObject jsonObject = (JSONObject) obj;
		    System.out.println(jsonObject);
		    String name = (String) jsonObject.get("name");
		    System.out.println("**************************"+name);
		    String place1=(String)jsonObject.get("**********************"+"place");
		    System.out.println(place1);			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
