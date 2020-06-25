package com.onlinebusreservation.model;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bus {
	@Id
	private BigInteger busNo;
	private String busName;
	private String busModel;
	private int seatCapacity;

	
	public Bus() {
	}

	/**
	 * @param flightNo
	 * @param carrierName
	 * @param flightModel
	 * @param seatCapacity
	 */
	public Bus(BigInteger busNo, String busName, String busModel, int seatCapacity) {
		super();
		this.busNo = busNo;
		this.busName = busName;
		this.busModel = busModel;
		this.seatCapacity = seatCapacity;
	}

	public BigInteger getBusNo() {
		return busNo;
	}

	public void setBusNo(BigInteger busNo) {
		this.busNo = busNo;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusModel() {
		return busModel;
	}

	public void setBusModel(String busModel) {
		this.busModel = busModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", busName=" + busName + ", busModel=" + busModel + ", seatCapacity="
				+ seatCapacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busModel == null) ? 0 : busModel.hashCode());
		result = prime * result + ((busName == null) ? 0 : busName.hashCode());
		result = prime * result + ((busNo == null) ? 0 : busNo.hashCode());
		result = prime * result + seatCapacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (busModel == null) {
			if (other.busModel != null)
				return false;
		} else if (!busModel.equals(other.busModel))
			return false;
		if (busName == null) {
			if (other.busName != null)
				return false;
		} else if (!busName.equals(other.busName))
			return false;
		if (busNo == null) {
			if (other.busNo != null)
				return false;
		} else if (!busNo.equals(other.busNo))
			return false;
		if (seatCapacity != other.seatCapacity)
			return false;
		return true;
	}

	

	
}
