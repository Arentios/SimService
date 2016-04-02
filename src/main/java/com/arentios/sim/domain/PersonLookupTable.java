package com.arentios.sim.domain;

import java.util.HashMap;

/**
 * Class to hold static lookup table for people
 * @author Arentios
 *
 */
public final class PersonLookupTable {
	
	private static HashMap<Long, Person> lookupTable = new HashMap<Long, Person>();
	
	static{
		
	}
	
	private PersonLookupTable(){	
	}
	
	
	public static Person lookupPerson(Long personId){
		return lookupTable.get(personId);	
	}
	
	public static Boolean addPerson(Person person){
		lookupTable.put(person.getPersonId(), person);
		return true;
	}
	
	

}
