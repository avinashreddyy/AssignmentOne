package com.onlinebusreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinebusreservation.exceptions.RecordAlreadyPresentException;
import com.onlinebusreservation.model.Booking;
import com.onlinebusreservation.service.TicketBookingService;

@RestController
@RequestMapping("/booking")
public class TicketBookingController {

	@Autowired(required = true)
	TicketBookingService ticketbookingService;

	@PostMapping("/createBooking")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addBooking(@RequestBody Booking newBooking) {

		ticketbookingService.createBooking(newBooking);
	}

	@GetMapping("/readAllBooking")
	public Iterable<Booking> readAllBookings() {

		return ticketbookingService.displayAllBooking();
	}

}