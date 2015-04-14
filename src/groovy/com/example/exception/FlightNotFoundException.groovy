package com.example.exception

class FlightNotFoundException  extends TravelException {

	public FlightNotFoundException(String message) {
		super(message)
	}

	public FlightNotFoundException(Exception e) {
		super(e.getMessage())
	}

}
