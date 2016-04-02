package com.arentios.sim.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {

	private Integer age;
	private Personality personality;
	private HashMap<String, Integer> Attributes;
	private Long personId;
	private Integer happiness;
	private ArrayList<Integer> parents;
	private ArrayList<Integer> children;
	
	Person(Personality parent1, Personality parent2){
		//personality = Personality.
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Personality getPersonality() {
		return personality;
	}
	public void setPersonality(Personality personality) {
		this.personality = personality;
	}

	public HashMap<String, Integer> getAttributes() {
		return Attributes;
	}

	public void setAttributes(HashMap<String, Integer> attributes) {
		Attributes = attributes;
	}

	public Integer getHappiness() {
		return happiness;
	}

	public void setHappiness(Integer happiness) {
		this.happiness = happiness;
	}

	public ArrayList<Integer> getParents() {
		return parents;
	}

	public void setParents(ArrayList<Integer> parents) {
		this.parents = parents;
	}

	public ArrayList<Integer> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Integer> children) {
		this.children = children;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}


	
	
	
	
}
