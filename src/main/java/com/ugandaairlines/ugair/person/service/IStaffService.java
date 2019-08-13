package com.ugandaairlines.ugair.person.service;

import com.ugandaairlines.ugair.person.model.Staff;

public interface IStaffService {
	
	public abstract Staff saveStaff(Staff staff);
	public abstract Iterable<Staff> findAllStaffs();
	public abstract Staff findStaffById(Integer staffId);
	public abstract void deleteStaff(Staff staff);

}
