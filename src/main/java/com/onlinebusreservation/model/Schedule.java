package com.onlinebusreservation.model;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@Column(name = "schedule_Id")
	private BigInteger scheduleId;

	@OneToOne(fetch = FetchType.EAGER)
	private BusStation sourceBusStation;

	@OneToOne(fetch = FetchType.EAGER)
	private BusStation destinationBusStation;

	@Column(name = "departure_date")
	private String deptDateTime;

	@Column(name = "arrival_date")
	private String arrDateTime;

	public Schedule(BigInteger scheduleId, BusStation sourceBusStation, BusStation destinationBusStation,
			String deptDateTime, String arrDateTime) {
		super();
		this.scheduleId = scheduleId;
		this.sourceBusStation = sourceBusStation;
		this.destinationBusStation = destinationBusStation;
		this.deptDateTime = deptDateTime;
		this.arrDateTime = arrDateTime;
	}

	public Schedule() {

	}

	public BigInteger getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
	}

	public BusStation getSourceBusStation() {
		return sourceBusStation;
	}

	public void setSourceBusStation(BusStation sourceBusStation) {
		this.sourceBusStation = sourceBusStation;
	}

	public BusStation getDestinationBusStation() {
		return destinationBusStation;
	}

	public void setDestinationBusStation(BusStation destinationBusStation) {
		this.destinationBusStation = destinationBusStation;
	}

	public String getDeptDateTime() {
		return deptDateTime;
	}

	public void setDeptDateTime(String deptDateTime) {
		this.deptDateTime = deptDateTime;
	}

	public String getArrDateTime() {
		return arrDateTime;
	}

	public void setArrDateTime(String arrDateTime) {
		this.arrDateTime = arrDateTime;
	}

}
