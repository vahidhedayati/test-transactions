package com.example.exception

class CarNotFoundException extends TravelException {

	public CarNotFoundException(String message) {
		super(message)
	}

	public CarNotFoundException(Exception e) {
		super(e.getMessage())
	}
}
