package com.example.metrocard_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.metrocard_backend.dto.MetroCard;
import com.example.metrocard_backend.dto.Passenger;
import com.example.metrocard_backend.repo.MetroCardRepo;
import com.example.metrocard_backend.repo.PassengerRepo;

@Service
public class PassengerServiceImpl implements PassengerService{
	
	@Autowired
	private PassengerRepo passengerRepo;
	
	@Autowired
	private MetroCardRepo metroCardRepo;

	@Override
	public Passenger savePassenger(Passenger passenger) {
		MetroCard saveCard=metroCardRepo.save(passenger.getMetroCard());
		passenger.setMetroCard(saveCard);
		return passengerRepo.save(passenger);
	}

}
