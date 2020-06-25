package com.onlinebusreservation.service;

import org.springframework.http.ResponseEntity;

import com.onlinebusreservation.model.BusStation;

public interface BusStationService {
	public Iterable< BusStation> viewAllBusStation();

	public  BusStation viewBusStation(String  busStation);

	public ResponseEntity<?> addBusStation( BusStation  busStation);

	

	public String removeBusStation(String  BusStation);
}
