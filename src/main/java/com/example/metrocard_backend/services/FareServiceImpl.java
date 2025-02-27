package com.example.metrocard_backend.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.metrocard_backend.dto.AgeCategory;
import com.example.metrocard_backend.dto.Journey;
import com.example.metrocard_backend.dto.JourneyType;
import com.example.metrocard_backend.dto.MetroCard;
import com.example.metrocard_backend.dto.Passenger;
import com.example.metrocard_backend.dto.Station;
import com.example.metrocard_backend.dto.Transaction;
import com.example.metrocard_backend.dto.TransactionType;
import com.example.metrocard_backend.repo.JourneyRepo;
import com.example.metrocard_backend.repo.MetroCardRepo;
import com.example.metrocard_backend.repo.TransactionRepo;

@Service
public class FareServiceImpl implements FareService {
    @Autowired
    private MetroCardRepo metroCardRepo;
    
    @Autowired
    private JourneyRepo journeyRepo;
    
    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public double calculateFare(AgeCategory passengerType, JourneyType journeyType) {
        double fare;
        switch (passengerType) {
            case KID: 
                fare = 50;
                break;
            case ADULT:
                fare = 200;
                break;
            case SENIOR_CITIZEN:
                fare = 100;
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + passengerType);
        }

        if (journeyType == JourneyType.RETURN) {
            fare /= 2;  // Apply 50% discount for return journey
        }
        return fare;
    }

    @Override
    public void autoRecharge(MetroCard metroCard, double requiredAmount) {
        double serviceFee = requiredAmount * 0.02;  // 2% service fee
        double totalRechargeAmount = requiredAmount + serviceFee;

        // Update MetroCard balance
        metroCard.setBalance(metroCard.getBalance() + requiredAmount);
        metroCardRepo.save(metroCard);

        // Create and save transaction
        Transaction rechargeTransaction = new Transaction(
                0, // transactionId is auto-generated
                metroCard,
                TransactionType.RECHARGE,
                requiredAmount,
                serviceFee,
                LocalDateTime.now()
        );

        transactionRepo.save(rechargeTransaction);
    }


    @Override
    public void processJourney(Passenger passenger, Station source, Station destination, JourneyType journeyType) {
        MetroCard metroCard = passenger.getMetroCard();
        double fare = calculateFare(passenger.getAgeategory(), journeyType); // Fixed method name

        // Check if MetroCard has enough balance
        if (metroCard.getBalance() < fare) {
            autoRecharge(metroCard, fare - metroCard.getBalance());
        }

        // Deduct fare
        metroCard.setBalance(metroCard.getBalance() - fare);
        metroCardRepo.save(metroCard);

        // Create and save journey
        Journey journey = new Journey(metroCard, journeyType, source, destination, fare, LocalDateTime.now()); // Ensure constructor exists
        journeyRepo.save(journey);

        // Create and save transaction
        Transaction transaction = new Transaction(0, metroCard, TransactionType.FARE_DEDUCTION, fare, 0, LocalDateTime.now()); // Ensure constructor exists
        transactionRepo.save(transaction);

        System.out.println("Journey processed successfully for Passenger: " + passenger.getName());
    }

}
