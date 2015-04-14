package com.example.exception

class HotelNotFoundException extends TravelException {

	public HotelNotFoundException(String message) {
		super(message)
	}

	public HotelNotFoundException(Exception e) {
		super(e.getMessage())
	}
}
