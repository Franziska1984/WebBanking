package de.telekom.sea7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.telekom.sea7.model.implementation.ZahlungImpl;

@Repository
public interface ZahlungenRepository extends JpaRepository<ZahlungImpl, Integer>   {

	@Query(value = "SELECT sum(betrag) FROM zahlung_impl", nativeQuery = true)
    public Double umsatz();
	
	@Query(value = "SELECT sum(betrag) from zahlung_impl  where empfaenger in ('Franzi','Marco','Peggy','Oli') group by empfaenger", nativeQuery = true)
    public Double[] diagramm();

}	