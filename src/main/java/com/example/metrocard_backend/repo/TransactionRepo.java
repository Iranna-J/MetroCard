package com.example.metrocard_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.metrocard_backend.dto.Transaction;

@Repository
@EnableJpaRepositories
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

}
