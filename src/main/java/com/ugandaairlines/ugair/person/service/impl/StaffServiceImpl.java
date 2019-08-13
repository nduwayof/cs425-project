package com.ugandaairlines.ugair.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.person.model.Staff;
import com.ugandaairlines.ugair.person.repository.IStaffRepository;
import com.ugandaairlines.ugair.person.service.IStaffService;

@Service
public class StaffServiceImpl implements IStaffService {
	
	@Autowired
	private IStaffRepository staffRepository;

	@Override
	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	@Override
	public Iterable<Staff> findAllStaffs() {

		return staffRepository.findAll();
	}

	@Override
	public Staff findStaffById(Integer staffId) {

		return staffRepository.findById(staffId).orElse(null);
	}

	@Override
	public void deleteStaff(Staff staff) {
		staffRepository.delete(staff);
		
	}

}
