package de.telekom.sea7.model.implementation;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

@Service
public class Zahlungen implements Iterable <Zahlung>{
	
	private ArrayList<Zahlung> paymentsList = new ArrayList<>();
	

	        //Testdaten erzeugen
	        public void addTestzahlungen(int anzahl) {
	            int tester = 1;
	            for(int i = 0; i<anzahl; i++) {        // Schleife erwartet eine Anzahl welche bei Aufruf der Methode angefordert wird
	                Zahlung testdaten = new Zahlung();
	                testdaten.setEmpfaenger("Tester " + tester);
	                testdaten.setBetrag(tester + tester + tester + 0.7);
	                testdaten.setWaehrung("Euro");
	                testdaten.setVerwendungszweck("Testzweck " + tester);
	            paymentsList.add(testdaten);
	            tester++;
	            }
	        }

	 //Zwingend notwendig für die @RestController in der TransactionController Klasse
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
	
	public Zahlung get(int position)throws Exception {
	if (paymentsList.size()>= position && position >=0) {
		position = position -1;
		return paymentsList.get(position);	
	}else {
	throw new Exception();
	}
	
}
	public int getId(Zahlung zahlung) {
		return paymentsList.lastIndexOf(zahlung);
	}
}
