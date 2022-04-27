package com.mycompany.service;

import com.mycompany.dto.PersonDTO;

public interface PersonService {
	public boolean insertPerson(String id, String name);
	public boolean updatePerson(String id, String name);
	public boolean deletePerson(String id);
	public PersonDTO selectPerson(String id);
}
