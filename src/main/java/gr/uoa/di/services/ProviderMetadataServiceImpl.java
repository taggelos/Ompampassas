package gr.uoa.di.services;

import gr.uoa.di.entities.ProviderMetadata;
import gr.uoa.di.repositories.ProviderMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderMetadataServiceImpl implements ProviderMetadataService {
    @Autowired
    private ProviderMetadataRepository mProviderMetadataRepository;

    @Override
    public ProviderMetadata save(ProviderMetadata metadata) {
        return mProviderMetadataRepository.save(metadata);
    }

}