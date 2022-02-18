package de.telekom.sea7.model.implementation;

import org.springframework.stereotype.Service;

@Service
public class ZahlungImpl {

	private String empfaenger;
	private String iban;
	private String bic;
	private double betrag;
	private String waehrung;
	private String verwendungszweck;
	
	public ZahlungImpl() {

		this.empfaenger = "Karl";
		this.iban = "DE12345678";
		this.bic = "XXBDBDBDBD";
		this.betrag = 89.90;
		this.waehrung = "Euro";
		this.verwendungszweck = "Rammsteintickets";
	
	}
	

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

