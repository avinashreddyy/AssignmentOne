package com.onlinebusreservation.service;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.onlinebusreservation.dao.BusDao;
import com.onlinebusreservation.exceptions.RecordAlreadyPresentException;
import com.onlinebusreservation.exceptions.RecordNotFoundException;
import com.onlinebusreservation.model.Bus;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	BusDao busDao;

	
	public ResponseEntity<Bus> addBus(Bus bus) {
		Optional<Bus> findById = busDao.findById(bus.getBusNo());
		try {
			if (!findById.isPresent()) {
				busDao.save(bus);
				return new ResponseEntity<Bus>(bus, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException("Bus with number: " + bus.getBusNo() + " already present");
		} catch (RecordAlreadyPresentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	public Iterable<Bus> viewAllBus() {
		return busDao.findAll();
	}

	
	public Bus viewBus(BigInteger busNumber) {
		Optional<Bus> findById = busDao.findById(busNumber);
		if (findById.isPresent()) {
			return findById.get();
		} else
			throw new RecordNotFoundException("Bus with number: " + busNumber + " not exists");
	}

	
	public String removeBus(BigInteger busNumber) {
		Optional<Bus> findById = busDao.findById(busNumber);
		if (findById.isPresent()) {
			busDao.deleteById(busNumber);
			return "Bus removed!!";
		} else
			throw new RecordNotFoundException("Bus with number: " + busNumber + " not exists");

	}
}
