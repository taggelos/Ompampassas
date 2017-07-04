package gr.uoa.di.services;

import gr.uoa.di.entities.Ticket;
import gr.uoa.di.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository mTicketRepository;

    @Override
    public Ticket save(Ticket ticket) {
        return mTicketRepository.save(ticket);
    }

    @Override
    public Ticket findById(String id) {
        return mTicketRepository.findById(Integer.parseInt(id));
    }
}