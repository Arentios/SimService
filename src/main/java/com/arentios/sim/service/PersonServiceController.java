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
	
}
