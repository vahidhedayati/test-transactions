package com.example.exception

class CarNotFoundException extends TravelException {
	
	public CarNotFoundException() {
		super()
	}

	public CarNotFoundException(String message) {
		super(message)
	}

	public CarNotFoundException(Exception e) {
		super(e.getMessage())
	}

}
