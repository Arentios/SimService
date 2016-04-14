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
import org.springframework.stereotype.Service;

import com.arentios.sim.cache.PersonCacheManager;
import com.arentios.sim.cache.PersonLookupTable;
import com.arentios.sim.domain.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of Person Service
 * @author Arentios
 *
 */
public class PersonServiceImpl implements PersonService {

	
	private static Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
	private String serviceUrlString;
	
	
	public Person generatePerson() {
		return null;
	}
	
	public void fetchPersonData(){
		try {
			//XXX Hard coded for now until this is all pulled out into properties for injection
			URL serviceUrl = new URL(serviceUrlString);
			HttpURLConnection serviceConnection = (HttpURLConnection) serviceUrl.openConnection();
			serviceConnection.setRequestMethod("GET");
			serviceConnection.setRequestProperty("Accept", "application/json");
			
			InputStreamReader inputStream = new InputStreamReader(serviceConnection.getInputStream());
			BufferedReader reader =  new BufferedReader(inputStream);
			
			ObjectMapper mapper = new ObjectMapper();
			
			PersonCacheManager cacheManager = PersonCacheManager.getInstance();
			PersonLookupTable lookupManager = PersonLookupTable.getInstance();
			ArrayList<Person> personData = mapper.readValue(reader, new TypeReference<ArrayList<Person>>(){});
			for(Person currPerson : personData){
				lookupManager.addPerson(currPerson);
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
	
	public Person[] getAllPersonData(){
		PersonCacheManager cacheManager = PersonCacheManager.getInstance();	
		//This mixing of types and structures is not ideal but is here as a demonstration
		ArrayList<Long> personIds = cacheManager.getAllPersonKeys();
		Person[] results = new Person[personIds.size()];
		for(int i=0;i<results.length;i++){
			results[i] = cacheManager.getPerson(personIds.get(i));
		}
		return results;
	}

	public Person getPersonData(Long personId) {
		PersonCacheManager cacheManager = PersonCacheManager.getInstance();	
		return cacheManager.getPerson(personId);
	}

	public String getServiceUrlString() {
		return serviceUrlString;
	}

	public void setServiceUrlString(String serviceUrlString) {
		this.serviceUrlString = serviceUrlString;
	}

}
