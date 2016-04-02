package com.arentios.sim.simulate;

import java.util.ArrayList;
import java.util.Iterator;

import com.arentios.sim.domain.Person;

/**
 * Class which governs and controls the overall simulation
 * @author Arentios
 *
 */
public class SimulationController {

	ArrayList<Person> people;
	
	public Boolean processStep(){
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()){
			
		}
		
		return true;
	}
	
}
