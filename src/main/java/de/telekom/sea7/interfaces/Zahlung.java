package de.telekom.sea7.interfaces;

public interface Zahlung {

	
	public String getEmpfaenger();
	public void setEmpfaenger(String empfaenger);
	public String getIban();
	public void setIban(String iban);
	public String getBic();
	public void setBic(String bic);
	public double getBetrag();
	public void setBetrag(double betrag);
	public String getWaehrung();
	public void setWaehrung(String waehrung);
	public String getVerwendungszweck();
	public void setVerwendungszweck(String verwendungszweck);
}
