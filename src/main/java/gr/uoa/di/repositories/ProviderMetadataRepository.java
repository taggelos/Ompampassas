package gr.uoa.di.repositories;

import gr.uoa.di.entities.ProviderMetadata;
import org.springframework.data.repository.CrudRepository;

public interface ProviderMetadataRepository extends CrudRepository<ProviderMetadata, Long> {

}