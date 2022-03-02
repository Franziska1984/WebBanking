package de.telekom.sea7.model.implementation;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import de.telekom.sea7.interfaces.Zahlung;
import de.telekom.sea7.interfaces.Zahlungen;

@Service
public class ZahlungenImpl implements Iterable<Zahlung>,Zahlungen  {

	private ArrayList<Zahlung> paymentsList = new ArrayList<>();

	/**Testdaten erzeugen*/
	public void addTestzahlungen(int anzahl) {
		int tester = 1;
		/** Schleife erwartet eine Anzahl welche bei Aufruf der Methode angefordert wird*/
		for (int i = 0; i < anzahl; i++) { 
			Zahlung testdaten = new ZahlungImpl();
			testdaten.setEmpfaenger("Tester " + tester);
		//	testdaten.setIban("DE" + 1234546 + tester);
			testdaten.setBic("XXWWFHF");
			testdaten.setBetrag(tester + tester + tester + 0.7);
			testdaten.setWaehrung("Euro");
			testdaten.setVerwendungszweck("Testzweck " + tester);
			paymentsList.add(testdaten);
			tester++;
		}
	}

	// Zwingend notwendig für die @RestController in der TransactionController
	// Klasse
	public ArrayList<Zahlung> getPaymentsList() {
		return paymentsList;
	}

	public void add(Zahlung zahlung) {
		paymentsList.add(zahlung);
	}

	public int size() {
		return paymentsList.size();
	}

	public Iterator<Zahlung> iterator() {
		return paymentsList.iterator();
	}

	public Zahlung get(int position) throws Exception {
		if (paymentsList.size() >= position && position >= 0) {
			position = position - 1;
			return paymentsList.get(position);
		} else {
			throw new Exception();
		}
	}

	public int getId(Zahlung zahlung) {
		return paymentsList.lastIndexOf(zahlung);
	}

	public Zahlung delete(int position) {
		return paymentsList.remove(position);
	}

}
