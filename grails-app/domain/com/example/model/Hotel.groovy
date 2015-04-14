package com.example.model

class Hotel  {

	String hotelname
	String roomtype
	Integer bookings
	String toplace
	Integer totalrooms
	Date bookingdate
	static constraints = {
		roomtype size: 1..1
	}
	
	
}
