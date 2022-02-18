package de.telekom.sea7.view;

import org.springframework.stereotype.Controller;

@Controller
public interface View {
	 String getHtml();
	 String getJSON();
	 String getZahlungen();
	
}
