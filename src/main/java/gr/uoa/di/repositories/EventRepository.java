package gr.uoa.di.repositories;

import gr.uoa.di.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findByCategoryOrTitleOrDescription(String category, String title, String description);
    List<Event> findAll();
    Event findByTitle(String title);

    Event findById(Integer id);
}
