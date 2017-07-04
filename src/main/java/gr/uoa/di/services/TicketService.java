package gr.uoa.di.services;

import gr.uoa.di.entities.Ticket;


public interface TicketService {
    Ticket save(Ticket event);

    void delete(String id);
    Ticket findById(String id);
}