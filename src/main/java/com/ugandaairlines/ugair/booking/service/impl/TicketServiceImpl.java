package com.ugandaairlines.ugair.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.booking.model.Ticket;
import com.ugandaairlines.ugair.booking.repository.ITicketRepository;
import com.ugandaairlines.ugair.booking.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService {
	
	@Autowired
	private ITicketRepository ticketRepository;

	@Override
	public Ticket saveTicket(Ticket ticket) {

		return ticketRepository.save(ticket);
	}

	@Override
	public Iterable<Ticket> findAllPayments() {
		
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findTicketById(Integer ticketId) {
	
		return ticketRepository.findById(ticketId).orElse(null);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		ticketRepository.delete(ticket);
		
	}

}
