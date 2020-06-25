package com.onlinebusreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinebusreservation.exceptions.RecordAlreadyPresentException;
import com.onlinebusreservation.exceptions.RecordNotFoundException;
import com.onlinebusreservation.model.BusStation;
import com.onlinebusreservation.service.BusStationService;

@RestController
@RequestMapping("/busStation")
public class BusStationController {

	@Autowired(required = true)
	BusStationService busStationService;

	@GetMapping("/viewBusStation/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public BusStation viewBusStation(@PathVariable("id") String busStationCode) {
		return busStationService.viewBusStation(busStationCode);
	}

	@GetMapping("/allBusStation")
	public Iterable<BusStation> viewAllBusStation() {
		return busStationService.viewAllBusStation();
	}

	@PostMapping("/addBusStation")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addBusStation(@RequestBody BusStation busStation) {
		busStationService.addBusStation(busStation);
	}

	@DeleteMapping("/deleteBusStation/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeBusStation(@PathVariable("id") String busStationCode) {
		busStationService.removeBusStation(busStationCode);
	}
}
