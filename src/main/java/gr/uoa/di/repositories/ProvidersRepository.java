package gr.uoa.di.repositories;

import gr.uoa.di.entities.ProvidersEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProvidersRepository extends CrudRepository<ProvidersEntity, Long> {

}