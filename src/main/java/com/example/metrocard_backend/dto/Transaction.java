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
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;

	@ManyToOne
	@JoinColumn(name = "metrocard_id", referencedColumnName = "cardId", nullable = false)
	private MetroCard metroCard;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	private double amount;
	private double serviceFee;
	private LocalDateTime localDateTime;
	

	public Transaction(long transactionId, MetroCard metroCard, TransactionType transactionType, double amount,
			double serviceFee, LocalDateTime localDateTime) {
		super();
		this.transactionId = transactionId;
		this.metroCard = metroCard;
		this.transactionType = transactionType;
		this.amount = amount;
		this.serviceFee = serviceFee;
		this.localDateTime = localDateTime;
	}


	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public MetroCard getMetroCard() {
		return metroCard;
	}

	public void setMetroCard(MetroCard metroCard) {
		this.metroCard = metroCard;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

}
