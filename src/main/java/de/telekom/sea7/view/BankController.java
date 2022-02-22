package de.telekom.sea7.view;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Controller + @ResponseBody = @RestController > wenn alle Methoden eine JSON zurückgeben
public class BankController {

	/**
	 * Protokoll: 	https (normal https)
	 * ://
	 * Host: 	 	localhost (oder sonst einer)
	 * Pfad(Path):	/search/pens
	 * ?
	 * RequestParameter: Kontonummer
	 */

	@GetMapping("/{search}/{kundennummer}")
	//@ResponseBody	> kann über die Klasse geschrieben werden (BankController)
	public String getKontostand(	
		@PathVariable ("kundennummer") String kundennummer,
		@RequestParam ("datum") String datum,
	    @RequestParam ("kontonummer") int kontonummer){
		return String.format("{\"kundennummer\":\"%s\",\"kundennummer\":\"%s\"}",
				kundennummer, kontonummer);
}
	
	
	
}
