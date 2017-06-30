package gr.uoa.di.services;

import gr.uoa.di.entities.Place;
import gr.uoa.di.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceRepository mPlaceRepository;

    @Override
    public Place save(Place place) {
        return mPlaceRepository.save(place);
    }
}