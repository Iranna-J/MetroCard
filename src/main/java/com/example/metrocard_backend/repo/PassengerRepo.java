package com.example.metrocard_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.metrocard_backend.dto.Passenger;

@Repository
@EnableJpaRepositories
public interface PassengerRepo extends JpaRepository<Passenger, Long>{

}
