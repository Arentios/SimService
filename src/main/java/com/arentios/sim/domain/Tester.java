package com.arentios.sim.domain;

import com.arentios.sim.service.PersonService;
import com.arentios.sim.service.PersonServiceImpl;

public class Tester {

	public static void main(String[] args) {
		PersonService personService = new PersonServiceImpl();
		personService.fetchPersonData();

	}

}
