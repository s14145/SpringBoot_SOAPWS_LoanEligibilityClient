package com.springboot.soapwsclient.client;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.springboot.soapwsclient.loaneligibility.Acknowledgement;
import com.springboot.soapwsclient.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityClient extends WebServiceGatewaySupport{
	
	@Value("${loaneligibility.client.enpoint-url}")
	private String url;

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;
	
	private WebServiceTemplate webServiceTemplate;

	public Acknowledgement getLoanStatus(CustomerRequest request) {
		if(Objects.isNull(request)) {
			throw new RuntimeException("Please provide customer request details");
		}
		
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		Acknowledgement acknowledgement = (Acknowledgement) webServiceTemplate.marshalSendAndReceive(url,request);
				
		return acknowledgement;
	}

}
