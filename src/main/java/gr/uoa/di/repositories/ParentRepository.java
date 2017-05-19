package gr.uoa.di.repositories;

import gr.uoa.di.entities.ParentEntity;
import gr.uoa.di.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ParentRepository extends CrudRepository<ParentEntity, Long> {

}