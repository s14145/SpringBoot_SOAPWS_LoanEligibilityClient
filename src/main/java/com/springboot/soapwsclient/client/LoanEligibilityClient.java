package com.springboot.soapwsclient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.springboot.soapwsclient.loaneligibility.Acknowledgement;
import com.springboot.soapwsclient.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityClient {

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	private WebServiceTemplate webServiceTemplate;

	public Acknowledgement getLoanStatus(CustomerRequest request) {
		if(request == null || StringUtils.isEmpty(request)) {
			throw new RuntimeException("Please provide customer request details");
		}
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		Acknowledgement acknowledgement = (Acknowledgement) webServiceTemplate
				.marshalSendAndReceive("http://localhost:8080/ws/loanEligibility.wsdl", request);
		return acknowledgement;
	}

}
