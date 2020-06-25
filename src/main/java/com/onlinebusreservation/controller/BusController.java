package com.onlinebusreservation.controller;

import java.math.BigInteger;
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
import com.onlinebusreservation.model.Bus;
import com.onlinebusreservation.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {
	@Autowired(required = true)
	BusService busService;

	@PostMapping("/addBus")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addBus(@RequestBody Bus bus) {
		busService.addBus(bus);
	}

	@GetMapping("/allBus")
	public Iterable<Bus> viewAllBus() {
		return busService.viewAllBus();
	}

	@GetMapping("/viewBus/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Bus viewBus(@PathVariable("id") BigInteger busNo) {
		return busService.viewBus(busNo);
	}

	
	@DeleteMapping("/deleteBus/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeBus(@PathVariable("id") BigInteger busNo) {
		busService.removeBus(busNo);
	}
}
