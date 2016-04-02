package com.arentios.sim.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.arentios.sim.domain.Person;

public class PersonServiceImpl implements PersonService {

	public Person generatePerson() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void fetchPersonData(){
		try {
			URL serviceUrl = new URL("http://localhost:5000/data");
			HttpURLConnection serviceConnection = (HttpURLConnection) serviceUrl.openConnection();
			serviceConnection.setRequestMethod("GET");
			serviceConnection.setRequestProperty("Accept", "application/json");
			
			InputStreamReader inputStream = new InputStreamReader(serviceConnection.getInputStream());
			BufferedReader reader =  new BufferedReader(inputStream);
			
			String data;
			data = reader.readLine();
			System.out.println(data);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
