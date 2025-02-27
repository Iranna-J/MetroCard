package com.example.metrocard_backend.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long passengerId;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private AgeCategory ageCategory;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="metrocard_id", referencedColumnName = "cardId")
	private MetroCard metroCard;

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AgeCategory getAgeategory() {
		return ageCategory;
	}

	public void setAgeategory(AgeCategory ageategory) {
		this.ageCategory = ageategory;
	}

	public MetroCard getMetroCard() {
		return metroCard;
	}

	public void setMetroCard(MetroCard metroCard) {
		this.metroCard = metroCard;
	}
	
	
}
