package de.telekom.sea7.interfaces;

import java.util.ArrayList;
import java.util.Iterator;


public interface Zahlungen {

	public void addTestzahlungen(int anzahl);
	public ArrayList<Zahlung> getPaymentsList();
	public void add(Zahlung zahlung);
	public int size();
	public Iterator<Zahlung> iterator();
	public Zahlung get(int position) throws Exception;
	public int getId(Zahlung zahlung);
	public Zahlung delete(int position);
}
