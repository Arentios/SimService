package com.arentios.sim.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

	private Integer age;
	private Personality personality;
	private HashMap<String, Integer> attributes;
	private Long personId;
	private Integer happiness;
	private ArrayList<Integer> parents;
	private ArrayList<Integer> children;
	private ArrayList<Integer> partner;
	private Boolean alive;
	
	Person(Personality parent1, Personality parent2){
		//personality = Personality.
	}
	
	public Person(){
		
	}
	
	public Person(Long personId, Integer age, Integer happiness){
		this.personId = personId;
		this.age = age;
		this.happiness = happiness;
		this.alive = true;
		this.parents = new ArrayList<Integer>();
		this.children = new ArrayList<Integer>();
		this.partner = new ArrayList<Integer>();
		this.attributes = new HashMap<String, Integer>();		
	}
	
	public Person(Long personId){	
		this.personId = personId;
		this.parents = new ArrayList<Integer>();
		this.children = new ArrayList<Integer>();
		this.partner = new ArrayList<Integer>();
		this.alive = true;
		this.attributes = new HashMap<String, Integer>();
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

	public HashMap<String, Integer> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, Integer> attributes) {
		this.attributes = attributes;
	}

	public ArrayList<Integer> getPartner() {
		return partner;
	}

	public void setPartner(ArrayList<Integer> partner) {
		this.partner = partner;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Person ["
				+ (age != null ? "age=" + age + ", " : "")
				+ (personality != null ? "personality=" + personality + ", "
						: "")
				+ (attributes != null ? "attributes=" + attributes + ", " : "")
				+ (personId != null ? "personId=" + personId + ", " : "")
				+ (happiness != null ? "happiness=" + happiness + ", " : "")
				+ (parents != null ? "parents=" + parents + ", " : "")
				+ (children != null ? "children=" + children + ", " : "")
				+ (partner != null ? "partner=" + partner + ", " : "")
				+ (alive != null ? "alive=" + alive : "") + "]";
	}

	/**
	 * Generate a random set of basic attributes
	 */
	public void randomize(){
		Random rand = new Random();
		this.age = rand.nextInt(12)+18;
		this.happiness = rand.nextInt(50)+50;
	}
	
	
	
	
}
