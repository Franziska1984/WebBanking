package de.telekom.sea7.model.implementation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IbanImpl {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id_iban;
	
	
	@Column (name = "iban")
	private String iban;
	
	public IbanImpl() {
	}
	
	public IbanImpl(String iban) {
		this.iban = iban;
	}

	public int getId_iban() {
		return id_iban;
	}

	public void setId_iban(int id_iban) {
		this.id_iban = id_iban;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
}
