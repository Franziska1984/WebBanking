package de.telekom.sea7.interfaces;

import de.telekom.sea7.model.implementation.IbanImpl;

public interface Zahlung {

	
	public String getEmpfaenger();
	public void setEmpfaenger(String empfaenger);
	public IbanImpl getIban();
	public void setIban(IbanImpl iban);
	public String getBic();
	public void setBic(String bic);
	public double getBetrag();
	public void setBetrag(double betrag);
	public String getWaehrung();
	public void setWaehrung(String waehrung);
	public String getVerwendungszweck();
	public void setVerwendungszweck(String verwendungszweck);
}
