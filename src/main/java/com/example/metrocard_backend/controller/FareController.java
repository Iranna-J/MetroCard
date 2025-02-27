package com.example.metrocard_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.metrocard_backend.dto.JourneyType;
import com.example.metrocard_backend.dto.Passenger;
import com.example.metrocard_backend.dto.Station;
import com.example.metrocard_backend.repo.PassengerRepo;
import com.example.metrocard_backend.services.FareService;

@RestController
@RequestMapping("/fare")
public class FareController {
	@Autowired
	private FareService fareService;
	
	@Autowired 
	private PassengerRepo passengerRepo;
	
	@PostMapping
	public ResponseEntity<String> processJourney(
			@RequestParam long passengerid,
			@RequestParam Station source,
			@RequestParam Station destination,
			@RequestParam JourneyType journeyType){
		Passenger passenger=passengerRepo.findById(passengerid)
				.orElseThrow(()->new RuntimeException("Passenger Not Found"));
		
		fareService.processJourney(passenger, source, destination, journeyType);
		return ResponseEntity.ok("Journey processed successfully for passenger : " + passenger.getName());
	}
}
