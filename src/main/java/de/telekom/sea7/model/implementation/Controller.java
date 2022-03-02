package de.telekom.sea7.model.implementation;

import java.text.DecimalFormat;
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

import de.telekom.sea7.interfaces.Zahlung;
import de.telekom.sea7.repository.IbanRepository;
import de.telekom.sea7.repository.ZahlungenRepository;

@RestController 
public class Controller {

	@Autowired
	 private ZahlungenRepository payments;
	
	@Autowired
	IbanRepository ibanRepo;
	
	//alle Zahlungen
		@GetMapping("/allpayments")
		@ResponseBody
		  public List<ZahlungImpl> getPayments() {
	        List<ZahlungImpl> zahlung = payments.findAll();
	        return zahlung;
	        }
		
		//eine Zahlung
	    @GetMapping("/onepayment/{id}")
	    @ResponseBody
		public Optional<ZahlungImpl> getOnePayment(@PathVariable(name = "id") int id) {
			Optional<ZahlungImpl> zahlung = payments.findById(id);
			if (zahlung.isPresent()) {
				return zahlung;
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Die angefragte ID gibt es nicht!");
			}
			
		}
		
	    //löschen einer Zahlung	    
	    @DeleteMapping("/deletePayment/{id}")
		public void deleteOnePayment(@PathVariable("id") int id) {
			 payments.deleteById(id);
			 
		}
		
	    //neue Zahlung
	    @PostMapping("/postpayment/")
		public void addOnePayment(@RequestBody ZahlungImpl zahlung) {
			payments.save(zahlung);
		}
	   
	    //Summe aller Beträge
	    @GetMapping("/sumpayments")
		@ResponseBody
		public Double umsatz() {
	    //	DecimalFormat d = new DecimalFormat("#.##");   d.format
			return payments.umsatz();
			
		}
	    
	    //Berechnung für das Diagramm
	    @GetMapping("/sumdiagramm")
		@ResponseBody
		public Double[] diagramm() {
			return payments.diagramm();
		}  
}
