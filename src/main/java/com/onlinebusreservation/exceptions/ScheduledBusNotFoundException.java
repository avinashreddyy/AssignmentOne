package com.onlinebusreservation.exceptions;

public class ScheduledBusNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScheduledBusNotFoundException(String str) {
		super(str);
	}

}