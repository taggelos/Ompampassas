package gr.uoa.di.repositories;

import gr.uoa.di.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersEntity, Long> {

}