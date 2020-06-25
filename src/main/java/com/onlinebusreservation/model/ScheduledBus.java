package com.onlinebusreservation.model;

import java.math.BigInteger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class ScheduledBus {

	public ScheduledBus(BigInteger scheduleBusId, Bus bus, Integer availableSeats, Schedule schedule) {
		super();
		this.scheduleBusId = scheduleBusId;
		this.bus = bus;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	public ScheduledBus() {

	}

	@Id
	@Column(name = "schedule_bus_id")
	private BigInteger scheduleBusId;

	@OneToOne(fetch = FetchType.EAGER)
	@NotNull
	private Bus bus;

	@Column(name = "available_seats")
	@NotNull
	private Integer availableSeats;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;

	public BigInteger getScheduleBusId() {
		return scheduleBusId;
	}

	public void setScheduleBusId(BigInteger scheduleBusId) {
		this.scheduleBusId = scheduleBusId;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

}
