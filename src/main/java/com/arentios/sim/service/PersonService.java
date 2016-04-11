package com.arentios.sim.service;

import com.arentios.sim.domain.Person;

public interface PersonService {
	
	/**
	 * Generate a person from scratch
	 * @return
	 */
	public Person generatePerson();
	
	/**
	 * Call the Python web service to pull the person data from it in JSON form and insert it into the cache
	 */
	public void fetchPersonData();

	/**
	 * Return all of the person data from the cache
	 * @return
	 */
	public Person[] getAllPersonData();
	
	/**
	 * Get data for a given person ID
	 * @param personId
	 * @return
	 */
	public Person getPersonData(Long personId);
	
}
