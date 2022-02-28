package de.telekom.sea7.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.telekom.sea7.model.implementation.ZahlungImpl;

@Repository
public interface ZahlungenRepository extends CrudRepository<ZahlungImpl, Integer>   {


}	