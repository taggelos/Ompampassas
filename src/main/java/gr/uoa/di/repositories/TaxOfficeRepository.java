package gr.uoa.di.repositories;

import gr.uoa.di.entities.TaxOffice;
import org.springframework.data.repository.CrudRepository;

public interface TaxOfficeRepository extends CrudRepository<TaxOffice, Integer> {

}