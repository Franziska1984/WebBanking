package de.telekom.sea7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebBankingApplication {
	
	@Value("${spring.application.name}")
	
	public static void main(String[] args) {
		SpringApplication.run(WebBankingApplication.class, args);
			}
	//Runnable runnable = () -> System.out.println("Thats it");
	//runnable.run();
}
