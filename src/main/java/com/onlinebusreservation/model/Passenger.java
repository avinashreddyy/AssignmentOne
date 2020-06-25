package com.onlinebusreservation.model;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Passenger {
	@Id
	private BigInteger pnrNumber;
	private String passengerName;
	private int passengerAge;
	public BigInteger getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	
}
