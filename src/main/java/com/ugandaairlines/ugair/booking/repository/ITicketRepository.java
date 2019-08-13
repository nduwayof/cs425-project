package com.ugandaairlines.ugair.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.booking.model.Booking;
import com.ugandaairlines.ugair.booking.model.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

}
