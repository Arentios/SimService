package com.arentios.sim.domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Static class to hold constants for personalities
 * @author Arentios
 *
 */
public class PersonalityConstants {
	
	public static final ArrayList<String> personalityTraits;
	
	static{
		String[] traits = new String[]{"Focus", "Lust", "Creativity"};
		personalityTraits = new ArrayList<String>(Arrays.asList(traits));
	}

}
