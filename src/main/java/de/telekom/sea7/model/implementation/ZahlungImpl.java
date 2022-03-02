package de.telekom.sea7.model.implementation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import de.telekom.sea7.interfaces.Zahlung;

@Entity  //gibt an, dass das Objekt von Spring Data verwaltet wird 
         //und dass seine Attribute in Spalten von DB-Tabellen konvertiert werden
public class ZahlungImpl implements Zahlung{

	@Id   //gibt an, dass das Attribut als Primärschlüssel in der Tabelle
	      //verwendet werden soll, die der Entität entspricht.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 //was angibt, dass der Wert der ID beim Einfügen 
	 //in die Datenbank automatisch und inkrementell generiert wird.
	
	@Column (name = "id")
	private Integer id;
	@Column (name = "empfaenger")
	private String empfaenger;
	
	@ManyToOne (
				//fetch = FetchType.LAZY, 
				cascade=CascadeType.ALL)
	@JoinColumn (name = "ibanimpl_id_iban")
	private IbanImpl iban;
	
	@Column (name = "bic")
	private String bic;
	@Column (name = "betrag")
	private double betrag;
	@Column (name = "waehrung")
	private String waehrung;
	@Column (name = "verwendungszweck")
	private String verwendungszweck;
	
	
	
	public String getEmpfaenger() {
		return empfaenger;
	}

	public ZahlungImpl() {
		super();
	}

	public void setEmpfaenger(String empfaenger) {
		this.empfaenger = empfaenger;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IbanImpl getIban() {
		return iban;
	}

	public void setIban(IbanImpl iban) {
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
