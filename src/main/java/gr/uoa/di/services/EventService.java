package gr.uoa.di.services;

import gr.uoa.di.entities.Event;

import java.util.List;

public interface EventService {
    Event save(Event event);

    List<Event> findByCategoryOrTitleOrDescription(String category, String title, String description);

    List<Event> findAll();
}