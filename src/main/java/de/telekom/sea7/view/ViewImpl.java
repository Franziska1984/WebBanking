package de.telekom.sea7.view;

import java.time.LocalDateTime;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.model.implementation.ZahlungImpl;
import de.telekom.sea7.model.implementation.ZahlungenImpl;



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

	@GetMapping("test.json")
	@ResponseBody
	public String getJSON() {
		String empfaenger = zahlung.getEmpfaenger();
		String iban = zahlung.getIban();
		String bic = zahlung.getBic();
		Double betrag = zahlung.getBetrag();
		String waehrung = zahlung.getWaehrung();
		String verwendungszweck = zahlung.getVerwendungszweck();
		return "{" 
				+ " \"Empfaenger\": " + "\"" + empfaenger + "\"," 
		        + " \"Iban\": " + "\"" + iban + "\","
				+ " \"Bic\": " + "\"" + bic + "\","
				+ " \"Betrag\": " + "\"" + betrag + "\"," 
				+ " \"Waehrung\": " + "\""+ waehrung + "\","
				+ " \"Verwendungszweck\": " + "\"" + verwendungszweck + "\""
				+ "}";
	}
	
	/**
	 *Beispiele einfügen
	 * ArrayList auslesen, für jedes Zahlungsobjekt in json Format eine Ausgabe machen
	 * 
	 */
	
@GetMapping("/get.json")
@ResponseBody
public String getZahlungen() {
	zahlungen.add(zahlung);  //Bsp zahlungen in das Array hinzufügen
	zahlungen.add(zahlung1);
	zahlungen.add(zahlung2);
	
	//Deklaration Variable zur Erstellung des JSON Strings
	String ergebnis = "{";
	
	//for (ZahlungImpl tempZahlung:zahlungen)>>das ist die verkürzte Form für den Iterator} 
		
	// Initalisierung der Iterator-SSt von Java mit dem Parameter,
	// welche Objekte durchlaufen werden sollen (ZahlungenImpl-Objekte)
	// und der Zuweisung des Arrays das durchlaufen werden soll.
	
	// welche Werte willst du durchlaufen mit dem Namen tempZahlungIterator
	// dann dem Array Zahlungen zuweisen
	// Iteratormethode aus der Zahlungenimpl aufrufen
	Iterator<ZahlungImpl> tempZahlungIterator = zahlungen.iterator();
	
	//Zähler um die Ausgaben in den JSON zu nummerieren
	int id = 1;
	
	//Lieber Iterator solange du noch ein Objekt im Array findest(hasnext noch true ist, bei false Abbruch)
	//solange durchlaufe die Schleife
	//Zwischenspeicherung einzelner Zahlung Objekte aus Iteration
	while (tempZahlungIterator.hasNext()) {
		
		//next > holt das nächste Objekt raus
		ZahlungImpl tempZahlung = tempZahlungIterator.next();
		
		//Entpacken der Objekte mit getMethoden
		String empfaenger = tempZahlung.getEmpfaenger();
		String iban = tempZahlung.getIban();
		String bic = tempZahlung.getBic();
		Double betrag = tempZahlung.getBetrag();
		String waehrung = tempZahlung.getWaehrung();
		String verwendungszweck = tempZahlung.getVerwendungszweck();
		
		//eigene Variable damit dem Ergebnis das Ergebnis angefügt werden kann
		String tempIteration = 
			"\""+ id +"\":{" 
			+ " \"Empfaenger\": " + "\""+ empfaenger + "\"," 
			+ " \"Iban\": " + "\"" + iban + "\","
			+ " \"Bic\": " + "\"" + bic + "\","
			+ " \"Betrag\": " + "\"" + betrag + "\"," 
			+ " \"Waehrung\": " + "\""+ waehrung + "\","
			+ " \"Verwendungszweck\": " + "\"" + verwendungszweck + "\"" 
			+ " }";
		//Aufführen der ausgepackten Iterationsergebnisse an den JSON String
		ergebnis = ergebnis + tempIteration;
		
		//Bedingung, damit nach dem letzten Eintrag kein Komma im JSON String gebaut wird
		if (id <= zahlungen.size()-1) {
			ergebnis = ergebnis + ",";
		}
		//Hochzählen des Zählers für die Durchnummerierung der Ergebnisse
		id++;
}
	//Endklammer im JSON String nach Beendigung der Durchläufe anfügen
	ergebnis = ergebnis + "}";
	//Ergebnis zurückgeben
	return ergebnis;
}



	/**@GetMapping("/test.css")
	@ResponseBody
	public String getCSS() {
		String css = "<@charset 'UTF-8'>";

		return css;
	}
*/
}

