package com.onlinebusreservation.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.onlinebusreservation.dao.BusStationDao;
import com.onlinebusreservation.exceptions.RecordAlreadyPresentException;
import com.onlinebusreservation.exceptions.RecordNotFoundException;
import com.onlinebusreservation.model.BusStation;

@Service
public class BusStationServiceImpl implements BusStationService {
	@Autowired
	BusStationDao busStationDao;

	
	public Iterable<BusStation> viewAllBusStation() {
		return busStationDao.findAll();
	}

	
	public BusStation viewBusStation(String busStationCode) {
		Optional<BusStation> findById = busStationDao.findById(busStationCode);
		return findById.get();
	}

	
	public ResponseEntity<?> addBusStation(BusStation busStation) {
		Optional<BusStation> findById = busStationDao.findById(busStation.getBusStationCode());
		try {
			if (!findById.isPresent()) {
				busStationDao.save(busStation);
				return new ResponseEntity<BusStation>(busStation, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"BusStation with code : " + busStation.getBusStationCode() + " already present");
		} catch (RecordAlreadyPresentException e) {
			return new ResponseEntity<BusStation>(busStation, HttpStatus.NOT_FOUND);
		}
	}


	
	public String removeBusStation(String busStationCode) {
		Optional<BusStation> findById = busStationDao.findById(busStationCode);
		if (findById.isPresent()) {
			busStationDao.deleteById(busStationCode);
			return "BusStation removed";
		} else
			throw new RecordNotFoundException("BusStation with code: " + busStationCode + " not exists");

	}
}
