package gr.uoa.di.repositories;

import gr.uoa.di.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByCategoryOrTitleOrDescription(String category, String title, String description);
}