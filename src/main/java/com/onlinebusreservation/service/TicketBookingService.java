package com.onlinebusreservation.service;

import org.springframework.http.ResponseEntity;
import com.onlinebusreservation.model.Booking;

public interface TicketBookingService {
	public ResponseEntity<?> createBooking(Booking newBooking);

	public Iterable<Booking> displayAllBooking();

}
