package com.springboot.soapwsclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.springboot.soapwsclient.client.LoanEligibilityClient;


@Configuration
public class LoanEligConfig {
	
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2Marshaller= new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan("com.springboot.soapwsclient.loaneligibility");
		return jaxb2Marshaller;
	}
		
	

}
