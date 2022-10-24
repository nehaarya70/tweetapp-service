package com.tweetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.activemq.JmsProducer;

@RestController
@CrossOrigin(origins = "*")
public class HealthController {

	@Autowired
	JmsProducer jmsProducer;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String healthCheck() {
		jmsProducer.sendMessage("Healthy!");
		return "Healthy";
	}
}
