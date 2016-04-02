package com.arentios.sim.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.arentios.sim.domain.Person;
import com.arentios.sim.domain.PersonLookupTable;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonServiceImpl implements PersonService {

	public Person generatePerson() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void fetchPersonData(){
		try {
			//XXX Hard coded for now until this is all pulled out into properties for injection
			URL serviceUrl = new URL("http://localhost:5000/data");
			HttpURLConnection serviceConnection = (HttpURLConnection) serviceUrl.openConnection();
			serviceConnection.setRequestMethod("GET");
			serviceConnection.setRequestProperty("Accept", "application/json");
			
			InputStreamReader inputStream = new InputStreamReader(serviceConnection.getInputStream());
			BufferedReader reader =  new BufferedReader(inputStream);
			
			ObjectMapper mapper = new ObjectMapper();
			

			ArrayList<Person> personData = mapper.readValue(reader, new TypeReference<ArrayList<Person>>(){});
			for(Person currPerson : personData){
				PersonLookupTable.addPerson(currPerson);
				System.out.println(currPerson.getPersonId() + " " + PersonLookupTable.lookupPerson(currPerson.getPersonId()).getAge());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
