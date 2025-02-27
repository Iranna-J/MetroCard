package com.example.metrocard_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.metrocard_backend.dto.Passenger;
import com.example.metrocard_backend.services.PassengerService;

@RestController
@RequestMapping("/user")
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	@PostMapping
	public Passenger savePassenger(@RequestBody Passenger passenger) {
		return passengerService.savePassenger(passenger);
	}
}
