package gr.uoa.di.repositories;

import gr.uoa.di.entities.Ticket;
import org.springframework.data.repository.CrudRepository;


public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    Ticket findById(Integer id);
}
