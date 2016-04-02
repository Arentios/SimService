package com.arentios.sim.service;

/**
 * Tester class for use before turning this into a web service
 * @author Arentios
 *
 */
public class Tester {

	public static void main(String[] args) {
		PersonService personService = new PersonServiceImpl();
		personService.fetchPersonData();
		
	}

}
