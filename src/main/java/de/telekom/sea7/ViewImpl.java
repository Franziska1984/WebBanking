package de.telekom.sea7;

import java.time.LocalDateTime;
import java.util.Iterator;

import de.telekom.sea7.ZahlungImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class ViewImpl implements View {

	@Autowired
	ZahlungImpl zahlung;
	@Autowired
	ZahlungImpl zahlung1;
	@Autowired
	ZahlungImpl zahlung2;
	@Autowired
	ZahlungenImpl zahlungen;


	@GetMapping("/test.html")
	@ResponseBody
	public String getHtml() {
		String body = LocalDateTime.now().toString();
		String html = "<!doctype html>" 
				+ "<html>" + " " 
				+ "<head>" 
				+ " <title>WebBanking</title>"
				+ " </head>" 
				+ " <body>" 
				+ " <h1>WebBanking</h1>" 
				+ " <p>Übersicht Kontobewegung</p>"
				+ " <h1>WebBanking</h1>" 
				+ body
				+ " </body>" 
				+ " </html>";
		return html;
	}

	@GetMapping("/test.json")
	@ResponseBody
	public String getJSON() {
		String empfaenger = zahlung.getEmpfaenger();
		String iban = zahlung.getIban();
		String bic = zahlung.getBic();
		Double betrag = zahlung.getBetrag();
		String waehrung = zahlung.getWaehrung();
		String verwendungszweck = zahlung.getVerwendungszweck();
		return "{\"Zahlung\":{" 
				+ " \"Empfaenger\": " + "\"" + empfaenger + "\"," 
		        + " \"Iban\": " + "\"" + iban + "\","
				+ " \"Bic\": " + "\"" + bic + "\","
				+ " \"Betrag\": " + "\"" + betrag + "\"," 
				+ " \"Waehrung\": " + "\""+ waehrung + "\","
				+ " \"Verwendungszweck\": " + "\"" + verwendungszweck + "\","
				+ "}}";
	}
	
	/**
	 *Beispiele einfügen
	 * ArrayList auslesen, für jedes Zahlungsobjekt in json Format eine Ausgabe machen
	 * 
	 */
	
@GetMapping("/get.json")
@ResponseBody
public String getZahlungen() {
	zahlungen.add(zahlung);  //für Bsp Daten eingefügt
	zahlungen.add(zahlung1);
	zahlungen.add(zahlung2);
	
	String ergebnis = "{";
	/**for (ZahlungImpl tempZahlung:zahlungen) {
		
		
		das ist die verkürzte Form für den Iterator
		
	}*/
	
	Iterator<ZahlungImpl> tempZahlungIterator = zahlungen.iterator();
	int id = 1;
	while (tempZahlungIterator.hasNext()) {
		ZahlungImpl tempZahlung = tempZahlungIterator.next();
		String empfaenger = tempZahlung.getEmpfaenger();
		String iban = tempZahlung.getIban();
		String bic = tempZahlung.getBic();
		Double betrag = tempZahlung.getBetrag();
		String waehrung = tempZahlung.getWaehrung();
		String verwendungszweck = tempZahlung.getVerwendungszweck();
		String tempIteration = 
			"\""+ id +"\":{" 
			+ " \"Empfaenger\": " + "\""+ empfaenger + "\"," 
			+ " \"Iban\": " + "\"" + iban + "\","
			+ " \"Bic\": " + "\"" + bic + "\","
			+ " \"Betrag\": " + "\"" + betrag + "\"," 
			+ " \"Waehrung\": " + "\""+ waehrung + "\","
			+ " \"Verwendungszweck\": " + "\"" + verwendungszweck + "\"" 
			+ " }";
		ergebnis = ergebnis + tempIteration;	
		if (id <= zahlungen.size()-1) {
			ergebnis = ergebnis + ",";
		}
		id++;
}
	ergebnis = ergebnis + "}";
	return ergebnis;
}



	/**@GetMapping("/test.css")
	@ResponseBody
	public String getCSS() {
		String css = "<@charset 'UTF-8'>";

		return css;
	}

	public String getJS() {
	return "console.log ('Hi')";
}
*/
}

