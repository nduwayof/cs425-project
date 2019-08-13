package com.ugandaairlines.ugair.booking.service;

import com.ugandaairlines.ugair.booking.model.Ticket;

public interface ITicketService {
	
	public abstract Ticket saveTicket(Ticket ticket);
	public abstract Iterable<Ticket> findAllPayments();
	public abstract Ticket findTicketById(Integer ticketId);
	public abstract void deleteTicket(Ticket ticket);

}
