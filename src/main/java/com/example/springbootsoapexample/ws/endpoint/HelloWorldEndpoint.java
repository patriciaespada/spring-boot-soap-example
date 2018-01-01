package com.example.springbootsoapexample.ws.endpoint;

import org.example.helloworld.Greeting;
import org.example.helloworld.ObjectFactory;
import org.example.helloworld.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloWorldEndpoint {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldEndpoint.class);
	
	private static final String NAMESPACE_URI = "http://www.example.org/helloworld/";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "person")
	@ResponsePayload
	public Greeting sayHello(@RequestPayload Person request) {
		// handling method that matches the incoming request, it receives a Person and returns a Greeting
		
		LOGGER.info("Endpoint received person[firstname={},lastName={}]", request.getFirstName(), request.getLastName());
		
		String greeting = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";
		
		ObjectFactory factory = new ObjectFactory();
		Greeting response = factory.createGreeting();
		response.setGreeting(greeting);
		
		LOGGER.info("Endpoint sending greeting='{}'", response.getGreeting());
		return response;
	}

}
