package com.onlinebusreservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class BusStation {


@Id
private String busStationCode;
private String busStationLocation;
private String busStationName;

public BusStation(String busStationName, String busStationLocation, String busStationCode)
/**
 * parameterized Constructor
 */
{
	this.busStationName = busStationName;
	this.busStationLocation = busStationLocation;
	this.busStationCode = busStationCode;
}

public BusStation()
/**
 * Unparameterized Constructor
 */
{
	
}

public String getBusStationCode() {
	return busStationCode;
}

public void setBusStationCode(String busStationCode) {
	this.busStationCode = busStationCode;
}

public String getBusStationLocation() {
	return busStationLocation;
}

public void setBusStationLocation(String busStationLocation) {
	this.busStationLocation = busStationLocation;
}

public String getBusStationName() {
	return busStationName;
}

public void setBusStationName(String busStationName) {
	this.busStationName = busStationName;
}
}