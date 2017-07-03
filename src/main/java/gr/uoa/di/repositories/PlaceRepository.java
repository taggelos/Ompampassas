package gr.uoa.di.repositories;

import gr.uoa.di.entities.Place;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Integer> {

}