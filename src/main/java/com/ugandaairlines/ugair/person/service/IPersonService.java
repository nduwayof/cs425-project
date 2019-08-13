package com.ugandaairlines.ugair.person.service;

import com.ugandaairlines.ugair.person.model.Person;

public interface IPersonService {
	
	public abstract Person savePerson(Person person);
	public abstract Iterable<Person> findAllPersons();
	public abstract Person findPersonById(Integer personId);
	public abstract void deletePerson(Person person);

}
