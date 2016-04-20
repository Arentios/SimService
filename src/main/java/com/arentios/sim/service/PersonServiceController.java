package com.arentios.sim.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arentios.sim.domain.Person;

/**
 * Controller for RESTful services accessing person data
 * @author Arentios
 *
 */

@RestController
@RequestMapping("/person")
public class PersonServiceController {

	@Autowired
	private PersonService personService;
	private static Logger LOGGER = LoggerFactory.getLogger(PersonServiceController.class);
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public ResponseEntity<String> fetchPersonData(){
		LOGGER.info("Attempting to load person data");
		try{
			personService.fetchPersonData();
			return ResponseEntity.status(HttpStatus.OK).body("Person Data successfully retrieved");
		}
		catch(Exception e){
			LOGGER.error("Failed to RESTfully fetch person data");
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Failed to retrieve Person Data");
		}
		
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Person[] getAllPersonData(){
		LOGGER.info("Attempting to load person data");
		try{
			return personService.getAllPersonData();
			
		}
		catch(Exception e){
			LOGGER.error("Failed to RESTfully get all person data");
			LOGGER.error(e.getMessage());
			return null;
		}
		
	}
	
	@RequestMapping(value = "/get/{personId}", method = RequestMethod.GET)
	public Person getPersonData(@PathVariable Long personId){
		LOGGER.info("Attempting to load person data");
		try{
			return personService.getPersonData(personId);
		}
		catch(Exception e){
			LOGGER.error("Failed to RESTfully get person data for personId="+personId);
			LOGGER.error(e.getMessage());
			return null;
		}
		
	}
	
	/**
	 * Service call to generate a person with random attributes
	 * NOTE: This could easily be a GET request but best practices is to not allow underlying modifications on a GET
	 * @return
	 */
	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public Long generatePerson(){
		LOGGER.info("Attempting to generate generic person");
		return personService.generatePerson().getPersonId();
	}
	
	@RequestMapping(value = "/generate/{age}/{happiness}", method = RequestMethod.POST)
	public Long generatePerson(@PathVariable Integer age, @PathVariable Integer happiness){
		LOGGER.info("Attempting to generate generic person");
		return personService.generatePerson(age, happiness).getPersonId();
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> postPersonData(){
		LOGGER.info("Attempting to post person data");
		try{
			personService.postPersonData();
			return ResponseEntity.status(HttpStatus.OK).body("Uploaded Data successfully");
		}
		catch(Exception e){
			LOGGER.error("Failed to RESTfully upload person data");
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Failed to upload Person Data");
		}
	}
	
	
	
}
