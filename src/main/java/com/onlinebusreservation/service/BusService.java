package com.onlinebusreservation.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.onlinebusreservation.model.Bus;

public interface BusService {
	public ResponseEntity<?> addBus(Bus bus);

	public Iterable<Bus> viewAllBus();

	public Bus viewBus(BigInteger busNumber);

	public String removeBus(BigInteger busNumber);
}
