package com.onlinebusreservation.service;

import com.onlinebusreservation.model.ScheduledBus;

public interface ScheduledBusService {
	public ScheduledBus addScheduledBus(ScheduledBus scheduledFlight);

	public Iterable<ScheduledBus> viewAllScheduledBuses();

}
