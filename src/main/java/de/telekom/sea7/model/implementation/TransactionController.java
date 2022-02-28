package de.telekom.sea7.model.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.interfaces.Zahlung;
import de.telekom.sea7.interfaces.Zahlungen;
import de.telekom.sea7.repository.ZahlungenRepository;

@RestController 
public class TransactionController {
	
	 @Autowired
	 private ZahlungenRepository zahlungenRepository;
	
	/**Array für Testdaten erzeugen, hier ist das Array noch leer*/
	@Autowired
	Zahlungen paymentsList; 

	/**Methode um Testdaten ins Array zu schreiben*/
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
	/**@GetMapping ("/zahlungen/")
	public Zahlungen ausgabeZahlungen() {
		return paymentsList;
	}**/
	//für DB Anbindung
	@GetMapping("/zahlungen")
	public Iterable<ZahlungImpl> getPaymentsList() {
		return 	zahlungenRepository.findAll();
	}
	
	/**Methode zum Abholen einer Zahlung mit einer ID
    @GetMapping ("/zahlung/{id}")
    public Zahlung getZahlungen(@PathVariable(name="id")int id) throws Exception{
        return paymentsList.get(id);
    }*/
    
    //für DB Anbindung
    @GetMapping("/zahlung/{id}")
	public Zahlung getZahlung(@PathVariable int id) {
		Optional<ZahlungImpl> optionalZahlung = zahlungenRepository.findById(id);
		Zahlung zahlung = new ZahlungImpl();
		zahlung = optionalZahlung.get();
		return zahlung;
	}

    /**Methode zum löschen einer Zahlung > muss noch in der HTML.index mit aufgenommen werden
    @DeleteMapping("/zahlung/{id}")
            public Zahlung deleteZahlung(@PathVariable(name="id") int id){
                return paymentsList.delete(id);
            }*/
    
    //für DB Anbindung
    @DeleteMapping("/zahlung/{id}")
	public Zahlung deleteZahlung1(@PathVariable int id) {
		zahlungenRepository.deleteById(id);
		return null;
	}
	
    /**
    //Metode um eine bestehende Zahlung zu ändern > muss noch in der HTML.index mit aufgenommen werden
    //URL: http://localhost:8090/zahlung/5
    @PutMapping("/zahlung/{id}")
    public Zahlung updateZahlung(
                @RequestBody ZahlungImpl zahlung,
                @PathVariable ("id")int id) {
        paymentsList.delete(id);
        paymentsList.add(zahlung);
        return null; 
    }>>>>>die Methode wird nicht benutzt, löschen?
    **/

    /**Metode um eine neu Zahlung hinzuzufügen 
    *URL: http://localhost:8090/zahlungen/ >>alle Zahlungen abrufen
   
    @PostMapping("/zahlung/")
    public String addZahlung(
                @RequestBody ZahlungImpl zahlung) {
        paymentsList.add(zahlung);
        return "Danke"; 
    } */
    
    //für DB Anbindung
    @PostMapping("/zahlung")
	public Zahlung addZahlung1(@RequestBody ZahlungImpl zahlung) {
    	zahlungenRepository.save(zahlung);
		return null;
	}

    }