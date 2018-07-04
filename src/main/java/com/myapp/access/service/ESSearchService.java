package com.myapp.access.service;

import java.util.List;

import com.myapp.access.model.Person;

/**
 * Class description
 *
 * @author Pradnya Talekar
 * @date   25 Jun 2018
 */

public interface ESSearchService {
	
	public List<Person> findPersonByName(String name);

}
