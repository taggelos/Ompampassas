package gr.uoa.di.services;

import gr.uoa.di.entities.ParentMetadata;
import gr.uoa.di.repositories.ParentMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentMetadataServiceImpl implements ParentMetadataService {
    @Autowired
    private ParentMetadataRepository mParentMetadataRepository;

    @Override
    public ParentMetadata save(ParentMetadata metadata) {
        return mParentMetadataRepository.save(metadata);
    }
}