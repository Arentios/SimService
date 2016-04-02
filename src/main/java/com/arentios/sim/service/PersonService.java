package com.arentios.sim.service;

import com.arentios.sim.domain.Person;

public interface PersonService {
	
	/*
	 * Generate a person from scratch
	 */
	public Person generatePerson();
	
	/*
	 * Call the Python web service to pull the person data from it in JSON form
	 */
	public void fetchPersonData();
}
