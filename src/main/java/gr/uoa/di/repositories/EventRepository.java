package gr.uoa.di.repositories;

import gr.uoa.di.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}