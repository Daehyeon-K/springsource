package com.mycompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dto.PersonDTO;
import com.mycompany.mapper.PersonMapper;

@Service("person")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public boolean insertPerson(String id, String name) {
		return personMapper.insert(id, name)==1?true:false;
	}

	@Override
	public boolean updatePerson(String id, String name) {
		// TODO Auto-generated method stub
		return personMapper.update(id, name)==1?true:false;
	}

	@Override
	public boolean deletePerson(String id) {
		// TODO Auto-generated method stub
		return personMapper.delete(id)==1?true:false;
	}

	@Override
	public PersonDTO selectPerson(String id) {
		// TODO Auto-generated method stub
		return personMapper.select(id);
	}

}
