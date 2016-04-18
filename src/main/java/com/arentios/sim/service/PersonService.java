package com.arentios.sim.service;

import com.arentios.sim.domain.Person;

public interface PersonService {
	
	/**
	 * Generate a person from scratch with random attributes
	 * @return
	 */
	public Person generatePerson();
	
	/**
	 * Generate a person from scratch with the passed parameters
	 * @param age
	 * @param happiness
	 * @return
	 */
	public Person generatePerson(Integer age, Integer happiness);
	
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
