package gr.uoa.di.services;

import gr.uoa.di.entities.Event;
import gr.uoa.di.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository mEventRepository;

    @Override
    public Event save(Event event) {
        return mEventRepository.save(event);
    }
}