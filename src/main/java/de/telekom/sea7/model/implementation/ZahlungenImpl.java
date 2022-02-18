package de.telekom.sea7.model.implementation;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

@Service
public class ZahlungenImpl implements Iterable <ZahlungImpl>{
	
	private ArrayList<ZahlungImpl> paymentsList = new ArrayList<>();

	public void add(ZahlungImpl zahlung) {
		paymentsList.add(zahlung);
	}
	
	public int size() {
		return paymentsList.size();
	}
	
	public Iterator<ZahlungImpl> iterator() {	
	return paymentsList.iterator();
	}
	
	public ZahlungImpl get(int position)throws Exception {
	if (paymentsList.size()<= position && paymentsList.size()>=0) {
		return paymentsList.get(position);	
	}else {
	throw new Exception();
	}
	
}
	public int getId(ZahlungImpl zahlung) {
		return paymentsList.lastIndexOf(zahlung);
	}
}
