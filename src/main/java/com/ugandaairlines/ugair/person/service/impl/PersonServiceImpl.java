package com.ugandaairlines.ugair.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.person.model.Person;
import com.ugandaairlines.ugair.person.repository.IPersonRepository;
import com.ugandaairlines.ugair.person.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IPersonRepository personRepository;

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Iterable<Person> findAllPersons() {

		return personRepository.findAll();
	}

	@Override
	public Person findPersonById(Integer personId) {

		return personRepository.findById(personId).orElse(null);
	}

	@Override
	public void deletePerson(Person person) {
		personRepository.delete(person);
		
	}

}
