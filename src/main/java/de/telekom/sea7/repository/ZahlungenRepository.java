package de.telekom.sea7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.telekom.sea7.model.implementation.ZahlungImpl;

@Repository
public interface ZahlungenRepository extends JpaRepository<ZahlungImpl, Integer>   {

	//Abfrage für den Gesamtbetrag
	@Query(value = "SELECT round (sum(betrag),2) FROM zahlung_impl", nativeQuery = true)
    public Double umsatz();
	
	//Abfrage für die Beträge bestimmter Personen für das Diagramm
	@Query(value = "SELECT \n"
			+ "(SELECT sum(betrag) from zahlung_impl  where empfaenger in ('Franzi'))Franzi,\n"
			+ "(SELECT sum(betrag) from zahlung_impl  where empfaenger in ('Marco'))Marco,\n"
			+ "(SELECT sum(betrag) from zahlung_impl  where empfaenger in ('Peggy'))Peggy,\n"
			+ "(SELECT sum(betrag) from zahlung_impl  where empfaenger in ('Oli'))Oli;", nativeQuery = true)
    public Object diagramm();

}	