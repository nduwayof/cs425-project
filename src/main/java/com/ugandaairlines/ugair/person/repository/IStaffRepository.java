package com.ugandaairlines.ugair.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.person.model.Staff;

@Repository
public interface IStaffRepository extends JpaRepository<Staff, Integer> {

}
