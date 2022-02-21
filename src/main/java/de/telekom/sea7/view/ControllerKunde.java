package de.telekom.sea7.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerKunde {
	
	
	@GetMapping("/franzi")
	public String franzi(Model model) {

		String name = "letzte Überweisung";
		model.addAttribute("name", name);
		String name1 = "Empfaenger: Franzi";
		model.addAttribute("name1", name1);
		String name2 = "IBAN: DE123456789";
		model.addAttribute("name2", name2);
		String name3 = "BIC: XXWFFVV";
		model.addAttribute("name3", name3);
		String name4 = "Betrag: 100,00";
		model.addAttribute("name4", name4);
		String name5 = "Waehrung: Euro";
		model.addAttribute("name5", name5);
		String name6 = "Verwendungszweck: Einkauf";
		model.addAttribute("name6", name6);
		
		return "franzi";

	}
	@GetMapping("/marco")
	public String marco(Model model) {

		String name = "letzte Überweisung";
		model.addAttribute("name", name);
		String name1 = "Empfaenger: Marco";
		model.addAttribute("name1", name1);
		String name2 = "IBAN: DE123456789";
		model.addAttribute("name2", name2);
		String name3 = "BIC: XXWFFVV";
		model.addAttribute("name3", name3);
		String name4 = "Betrag: 100,00";
		model.addAttribute("name4", name4);
		String name5 = "Waehrung: Euro";
		model.addAttribute("name5", name5);
		String name6 = "Verwendungszweck: Einkauf";
		model.addAttribute("name6", name6);
		
		return "marco";

	}
}
