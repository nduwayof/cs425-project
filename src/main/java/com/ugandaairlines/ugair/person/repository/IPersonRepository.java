package com.ugandaairlines.ugair.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.person.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
