package com.arentios.sim.cache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.apache.commons.jcs.engine.control.CompositeCacheManager;
import org.apache.commons.jcs.engine.control.event.behavior.IElementEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arentios.sim.domain.Person;

/**
 * Basic JCS cache manager system for person objects
 * @author Arentios
 *
 */
public class PersonCacheManager {

	
	private static CacheAccess<Long, Person> personCache;
	private static Logger LOGGER = LoggerFactory.getLogger(PersonCacheManager.class);
	private static PersonCacheManager instance;
	
	private PersonCacheManager(){
		
		personCache = JCS.getInstance("personCache");
	}
	
	public static PersonCacheManager getInstance(){
		if (instance == null){
			instance = new PersonCacheManager();
		}
		return instance;
	}
	
	public boolean putPerson(Person person){
		try{
			//Clear out any old entry for this person
			if(person != null){
				personCache.remove(person.getPersonId());
			}
			personCache.put(person.getPersonId(), person);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}
	
	public Person getPerson(Long personId){
		try{
			Person person = personCache.get(personId);
			return person;
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return null;
		}

	}
	
	/**
	 * Return an array list of all person IDs from the cache
	 * @return
	 */
	public ArrayList<Long> getAllPersonKeys(){
		Set<Object> rawKeys = CompositeCacheManager.getInstance().getCache("personCache").getMemoryCache().getKeySet();
		ArrayList<Long> results = new ArrayList<Long>();
		for(Object o : rawKeys){
			results.add((Long) o);
		}	
		return results;
		
		
	}

}
