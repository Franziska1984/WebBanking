package de.telekom.sea7.model.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.telekom.sea7.repository.IbanRepository;
import de.telekom.sea7.repository.ZahlungenRepository;

@RestController 
public class Controller {

	@Autowired
	 private ZahlungenRepository payments;
	
	@Autowired
	IbanRepository ibanRepo;
	
	//Methode zum Aufruf aller Zahlungen
		@GetMapping("/allpayments")
		@ResponseBody
		  public List<ZahlungImpl> getPayments() {
	        List<ZahlungImpl> zahlung = payments.findAll();
	        return zahlung;
	      }
		
		//Methode zum Aufruf einer Zahlung
	    @GetMapping("/onepayment/{id}")
	    @ResponseBody
		public Optional<ZahlungImpl> getOnePayment(@PathVariable(name = "id") int id) {
			Optional<ZahlungImpl> zahlung = payments.findById(id);
			if (zahlung.isPresent()) {
				return zahlung;
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						  "Die angefragte ID gibt es nicht!");
			}	
		}
		
	    //Methode zum Löschen einer Zahlung	    
	    @DeleteMapping("/deletePayment/{id}")
		public void deleteOnePayment(@PathVariable("id") int id) {
			 payments.deleteById(id);	 
		}
		
	    //Methode zum Anlegen einer neuen Zahlung
	    @PostMapping("/postpayment/")
		public void addOnePayment(@RequestBody ZahlungImpl zahlung) {
			payments.save(zahlung);
		}
	   
	    //Methode zum Summieren aller Beträge
	    @GetMapping("/sumpayments")
		@ResponseBody
		public Double umsatz() {
			return payments.umsatz();	
		}
	    
	    //Methode zur Berechnung für das Diagramm
	    @GetMapping("/sumdiagramm")
		@ResponseBody
		public Object diagramm() {
	    	return payments.diagramm();
	    }
			
		
}
