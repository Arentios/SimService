package com.arentios.sim.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.arentios.sim.domain.Person;

/**
 * Class to hold lookup table for people
 * Using an instance pattern in order to allow for addition of thread safe behavior later
 * @author Arentios
 *
 */
public class PersonLookupTable {

	private static HashMap<Long, Person> lookupTable;
	private static PersonLookupTable instance;

	private PersonLookupTable(){	
		lookupTable = new HashMap<Long, Person>();

	}
	
	public static PersonLookupTable getInstance(){
		if (instance == null){
			instance = new PersonLookupTable();
		}
		return instance;
	}


	public Person lookupPerson(Long personId){
		return lookupTable.get(personId);	
	}

	public Boolean addPerson(Person person){
		if(person!= null){
			lookupTable.put(person.getPersonId(), person);
			return true;
		}
		return false;
	}

	/**
	 * Add an entire list of people
	 * @param people
	 * @return
	 */
	public Boolean bulkAddPeople(List<Person> people){
		for(Person person : people){
			if(person!= null){
				lookupTable.put(person.getPersonId(), person);
			}
		}
		return true;
	}


}
