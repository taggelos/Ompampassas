package gr.uoa.di.services;

import gr.uoa.di.entities.Event;
import gr.uoa.di.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository mEventRepository;

    @Override
    public Event save(Event event) {
        return mEventRepository.save(event);
    }

    @Override
    public List<Event> findByCategoryOrTitleOrDescription(String category, String title, String description) {
        return mEventRepository.findByCategoryOrTitleOrDescription(category, title, description) ;
    }

    public List<Event> findAll(){
        return mEventRepository.findAll();
    }

    @Override
    public Event findByTitle(String title) {
        return mEventRepository.findByTitle(title);
    }

}