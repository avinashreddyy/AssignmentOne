package com.onlinebusreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinebusreservation.dao.ScheduledBusDao;
import com.onlinebusreservation.model.ScheduledBus;

@Service
public class ScheduledBusServiceImpl implements ScheduledBusService {

	@Autowired
	ScheduledBusDao dao;

	@Override
	public ScheduledBus addScheduledBus(ScheduledBus scheduledBus) {
		return dao.save(scheduledBus);
	}

	public Iterable<ScheduledBus> viewAllScheduledBuses() {
		return dao.findAll();
	}

}
