package com.example.metrocard_backend.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Journey {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long journeyId;

	@ManyToOne
	@JoinColumn(name = "metrocard_id", referencedColumnName = "cardId", nullable = false)
	private MetroCard metroCard;

	@Enumerated(EnumType.STRING)
	private JourneyType journeyType;

	@Enumerated(EnumType.STRING)
	private Station source;

	@Enumerated(EnumType.STRING)
	private Station destination;

	private double fare;
	private LocalDateTime journeyTime;
	
	public Journey(MetroCard metroCard, JourneyType journeyType, Station source, Station destination, double fare, LocalDateTime journeyTime) {
	    this.metroCard = metroCard;
	    this.journeyType = journeyType;
	    this.source = source;
	    this.destination = destination;
	    this.fare = fare;
	    this.journeyTime = journeyTime;
	}


	public long getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(long journeyId) {
		this.journeyId = journeyId;
	}

	public MetroCard getMetroCard() {
		return metroCard;
	}

	public void setMetroCard(MetroCard metroCard) {
		this.metroCard = metroCard;
	}

	public JourneyType getJourneyType() {
		return journeyType;
	}

	public void setJourneyType(JourneyType journeyType) {
		this.journeyType = journeyType;
	}

	public Station getSource() {
		return source;
	}

	public void setSource(Station source) {
		this.source = source;
	}

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalDateTime getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(LocalDateTime journeyTime) {
		this.journeyTime = journeyTime;
	}

}
