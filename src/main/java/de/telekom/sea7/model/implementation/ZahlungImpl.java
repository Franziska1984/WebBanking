package de.telekom.sea7.model.implementation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

import de.telekom.sea7.interfaces.Zahlung;

@Entity  //gibt an, dass das Objekt von Spring Data verwaltet wird 
         //und dass seine Attribute in Spalten von DB-Tabellen konvertiert werden
public class ZahlungImpl implements Zahlung{

	@Id   //gibt an, dass das Attribut als Primärschlüssel in der Tabelle
	      //verwendet werden soll, die der Entität entspricht.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 //was angibt, dass der Wert der ID beim Einfügen 
	 //in die Datenbank automatisch und inkrementell generiert wird.
	private Integer id;
	private String empfaenger;
	private String iban;
	private String bic;
	private double betrag;
	private String waehrung;
	private String verwendungszweck;
	
	public String getEmpfaenger() {
		return empfaenger;
	}

	public void setEmpfaenger(String empfaenger) {
		this.empfaenger = empfaenger;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public String getWaehrung() {
		return waehrung;
	}

	public void setWaehrung(String waehrung) {
		this.waehrung = waehrung;
	}

	public String getVerwendungszweck() {
		return verwendungszweck;
	}

	public void setVerwendungszweck(String verwendungszweck) {
		this.verwendungszweck = verwendungszweck;
	}

}
