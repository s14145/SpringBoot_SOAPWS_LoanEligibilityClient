package com.springboot.soapwsclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.soapwsclient.client.LoanEligibilityClient;
import com.springboot.soapwsclient.loaneligibility.Acknowledgement;
import com.springboot.soapwsclient.loaneligibility.CustomerRequest;

@SpringBootApplication
@RestController
public class WsLoanEligibilityClientApplication {
	
	@Autowired
	private LoanEligibilityClient loanEligibilityClient;
	
	@GetMapping("/getLoanStatus")
	public ResponseEntity<Acknowledgement> invokeLoanStatus(@RequestBody CustomerRequest request) {
		Acknowledgement acknowledgement = loanEligibilityClient.getLoanStatus(request);
		return new ResponseEntity(acknowledgement, HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(WsLoanEligibilityClientApplication.class, args);
	}

}
