package com.example.metrocard_backend.services;

import com.example.metrocard_backend.dto.AgeCategory;
import com.example.metrocard_backend.dto.JourneyType;
import com.example.metrocard_backend.dto.MetroCard;
import com.example.metrocard_backend.dto.Passenger;
import com.example.metrocard_backend.dto.Station;

public interface FareService {
	 public double calculateFare(AgeCategory passengerType, JourneyType journeyType);
	 
	 public void autoRecharge(MetroCard metroCard, double requiredAmount);
	 
	 public void processJourney(Passenger passenger, Station source, Station destination, JourneyType journeyType);
}
