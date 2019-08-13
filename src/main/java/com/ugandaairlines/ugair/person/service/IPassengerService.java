package com.ugandaairlines.ugair.person.service;

import com.ugandaairlines.ugair.person.model.Passenger;

public interface IPassengerService {
	
	public abstract Passenger savePassenger(Passenger passenger);
	public abstract Iterable<Passenger> findAllPassengers();
	public abstract Passenger findPassengerById(Integer passengerId);
	public abstract void deletePassenger(Passenger passenger);

}
