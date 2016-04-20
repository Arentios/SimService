package com.arentios.sim.service;

import com.arentios.sim.domain.Person;

/**
 * Tester class for use before turning this into a web service
 * @author Arentios
 *
 */
public class Tester {

	public static void main(String[] args) {
		PersonService personService = new PersonServiceImpl();
		personService.fetchPersonData();
		personService.postPersonData();
		Person[] data = personService.getAllPersonData();
		for (Person person : data){
			System.out.println(person.toString());
		}
		System.out.println(personService.getPersonData(data[0].getPersonId()));
		
	}

}
