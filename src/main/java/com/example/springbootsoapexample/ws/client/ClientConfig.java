package com.example.springbootsoapexample.ws.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class ClientConfig {
	
	@Bean
	Jaxb2Marshaller jaxb2Marshaller() {
		// transform objects into XML before sending them across a transport and when receiving the response
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("org.example.helloworld");
		
		return jaxb2Marshaller;
	}
	
	@Bean
	public WebServiceTemplate webServiceTemplate() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(jaxb2Marshaller());
		webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
		webServiceTemplate.setDefaultUri("http://localhost:9090/example/ws/helloworld");
		
		return webServiceTemplate;
	}

}
