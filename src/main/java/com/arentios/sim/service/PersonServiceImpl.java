package com.arentios.sim.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Cache.PersonCacheManager;

import com.arentios.sim.domain.Person;
import com.arentios.sim.domain.PersonLookupTable;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of Person Service
 * @author Arentios
 *
 */
public class PersonServiceImpl implements PersonService {

	
	private static Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	
	public Person generatePerson() {
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
			
			PersonCacheManager cacheManager = PersonCacheManager.getInstance();
			ArrayList<Person> personData = mapper.readValue(reader, new TypeReference<ArrayList<Person>>(){});
			for(Person currPerson : personData){
				PersonLookupTable.addPerson(currPerson);
				cacheManager.putPerson(currPerson);
				LOGGER.debug("Adding personId="+currPerson.getPersonId() + " to cache");
			}			
		} catch (MalformedURLException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public Person[] getPersonData(){
		return null;
	}
}
