package de.telekom.sea7.model.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //ersetzt Controller und ResponseBody
public class TransactionController {
	
	//Array für Testdaten erzeugen
	@Autowired
	Zahlungen paymentsList; //ArrayList hier noch leer

	//Methode um Testdaten ins Array zu schreiben
	@GetMapping ("/testdaten/{anzahl}")
	@ResponseBody
	public String createTestdata(@PathVariable(name="anzahl") int anzahl) {
		paymentsList.addTestzahlungen(anzahl);
		return "Es wurden erfogreich Daten erzeugt! <a href=\"/index.html\">Startseite</a>";
	}
	
	/**Methode Rest SSt zur Ausgabe aller Zahlungen aus der ArrayList als JSON
	 * durch @RestController wird der Inhalt ArrayList direkt als JSON zurückgegeben 
	 * URL: http://localhost:8080/zahlungen/
	 */
	@GetMapping ("/zahlungen/")
	public Zahlungen ausgabeZahlungen() {
		return paymentsList;
	}
	
	@GetMapping ("/zahlung/{id}")
	public Zahlung getZahlungen(@PathVariable(name="id")int id) throws Exception{
		return paymentsList.get(id);
	}
	}
