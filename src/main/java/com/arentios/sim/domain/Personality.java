package com.arentios.sim.domain;

import java.util.HashMap;

/**
 * Class to hold the Personality of a Person
 * @author Arentios
 *
 */
public class Personality {

	private HashMap<String, Double> traits;

	/**
	 * Return the value for a given trait
	 * If the trait does not exist null will be returned, it's up to the consumer to handle this
	 * @param trait
	 * @return
	 */
	public Double getTraitValue(String trait){
		return traits.get(trait);
	}
	
	public HashMap<String, Double> getTraits() {
		return traits;
	}

	public void setTraits(HashMap<String, Double> traits) {
		this.traits = traits;
	}
	
	
	
}
