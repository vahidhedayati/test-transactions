package com.example.model

class Hotel  {

	String hotelname
	String roomtype
	int bookings
	String toplace
	int totalrooms
	Date bookingdate
	
	int roomsleft
	static transients = ['roomsleft']
	static mapping = { 
		roomsleft formula: 'BOOKINS + 1 - TOTALROOMS'
	}
	
	
	static constraints = {
		roomtype size: 1..1
	}
	
	
}
