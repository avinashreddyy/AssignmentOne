package com.onlinebusreservation.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.onlinebusreservation.dao.BookingDao;
import com.onlinebusreservation.exceptions.RecordAlreadyPresentException;
import com.onlinebusreservation.model.Booking;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

	@Autowired
	BookingDao bookingDao;

	public ResponseEntity<Booking> createBooking(Booking newBooking) {

		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				bookingDao.save(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public Iterable<Booking> displayAllBooking() {

		return bookingDao.findAll();
	}

}
