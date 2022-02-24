package de.telekom.sea7.model.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	 * URL: http://localhost:8090/zahlungen/
	 */
	@GetMapping ("/zahlungen/")
	public Zahlungen ausgabeZahlungen() {
		return paymentsList;
	}
	
	//Methode zum Abholen einer Zahlung mit einer ID
    @GetMapping ("/zahlung/{id}")
    public Zahlung getZahlungen(@PathVariable(name="id")int id) throws Exception{
        return paymentsList.get(id);
    }

    //Methode zum löschen einer Zahlung > muss noch in der HTML.index mit aufgenommen werden
    @DeleteMapping("/zahlung/{id}")
            public Zahlung deleteZahlung(@PathVariable(name="id") int id){
                return paymentsList.delete(id);
            }

    //Metode um eine bestehende Zahlung zu ändern > muss noch in der HTML.index mit aufgenommen werden
    //URL: http://localhost:8090/zahlung/5
    @PutMapping("/zahlung/{id}")
    public Zahlung updateZahlung(
                @RequestBody Zahlung zahlung,
                @PathVariable ("id")int id) {
        paymentsList.delete(id);
        paymentsList.add(zahlung);
        return null; 
    }

    //Metode um eine bestehende Zahlung hinzuzufügen > muss noch in der HTML.index mit aufgenommen werden
    // URL: http://localhost:8090/zahlungen/ >>alle Zahlungen abrufen
    @PostMapping("/zahlung/")
    public String addZahlung(
                @RequestBody Zahlung zahlung) {
        paymentsList.add(zahlung);
        return "Danke"; 
    }
    }