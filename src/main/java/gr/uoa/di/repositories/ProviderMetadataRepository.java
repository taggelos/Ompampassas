package gr.uoa.di.repositories;

import gr.uoa.di.entities.ProviderMetadata;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProviderMetadataRepository extends CrudRepository<ProviderMetadata, Integer> {
    boolean existsByCompanyName(String name);

    boolean existsByVatNumber(String vat);

    List<ProviderMetadata> findAllByOrderByNumberOfRatingsDesc();

    List<ProviderMetadata> findTop4ByOrderByNumberOfRatingsDesc();

    List<ProviderMetadata> findAll();
}