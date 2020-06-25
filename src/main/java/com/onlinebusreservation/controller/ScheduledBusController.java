package com.onlinebusreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.onlinebusreservation.model.Schedule;
import com.onlinebusreservation.model.ScheduledBus;
import com.onlinebusreservation.service.BusService;
import com.onlinebusreservation.service.BusStationService;
import com.onlinebusreservation.service.ScheduledBusService;

@RestController

@RequestMapping("/scheduledBus")
public class ScheduledBusController {

	@Autowired
	ScheduledBusService scheduledBusService;

	@Autowired
	BusStationService busStationService;

	@Autowired
	BusService busService;

	@PostMapping("/add")
	public ResponseEntity<ScheduledBus> addSB(@ModelAttribute ScheduledBus scheduledBus,
			@RequestParam(name = "sourceBusStation") String source,
			@RequestParam(name = "destinationBusStation") String destination,
			@RequestParam(name = "deptDateTime") String departureTime,
			@RequestParam(name = "arrDateTime") String arrivalTime) {
		Schedule schedule = new Schedule();
		schedule.setScheduleId(scheduledBus.getScheduleBusId());
		schedule.setSourceBusStation(busStationService.viewBusStation(source));
		schedule.setDestinationBusStation(busStationService.viewBusStation(destination));
		schedule.setDeptDateTime(departureTime);
		schedule.setArrDateTime(arrivalTime);

		scheduledBus.setBus(busService.viewBus(scheduledBus.getScheduleBusId()));
		scheduledBus.setSchedule(schedule);
		scheduledBus.setAvailableSeats(scheduledBus.getBus().getSeatCapacity());
		try {
			return new ResponseEntity<ScheduledBus>(scheduledBusService.addScheduledBus(scheduledBus), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/viewAll")
	public Iterable<ScheduledBus> viewAllSB() {
		return scheduledBusService.viewAllScheduledBuses();
	}
}
