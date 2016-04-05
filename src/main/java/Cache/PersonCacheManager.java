package Cache;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arentios.sim.domain.Person;

/**
 * Basic JCS cache manager system for person objects
 * @author Arentios
 *
 */
public class PersonCacheManager {

	
	private static CacheAccess<String, Person> personCache;
	private static Logger LOGGER = LoggerFactory.getLogger(PersonCacheManager.class);
	private static PersonCacheManager instance;
	
	private PersonCacheManager(){
		
		personCache = JCS.getInstance("personCache");
	}
	
	public static PersonCacheManager getInstance(){
		if (instance == null){
			instance = new PersonCacheManager();
		}
		return instance;
	}
	
	public boolean putPerson(Person person){
		try{
			//Clear out any old entry for this person
			if(person != null){
				personCache.remove("person"+person.getPersonId());
			}
			personCache.put("person"+person.getPersonId(), person);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}
	
	public Person getPerson(Long personId){
		try{
			Person person = personCache.get("person"+personId);
			return person;
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return null;
		}
	}
}
