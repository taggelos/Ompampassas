package gr.uoa.di.repositories;

import gr.uoa.di.entities.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Long> {

}