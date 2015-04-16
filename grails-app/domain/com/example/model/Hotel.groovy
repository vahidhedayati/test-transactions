package com.example.model

class Hotel  {

	String hotelname
	String roomtype
	int bookings
	String toplace
	int totalrooms
	Date bookingdate
	
	int roomsleft
	//static transients = ['roomsleft']
	static mapping = { 
		roomsleft formula: 'TOTALROOMS - BOOKINGS'
	}
	
	
	static constraints = {
		roomtype size: 1..1
		roomsleft nullable: true
	}
	
	String toString() {
		hotelname
	}
	
}
