package com.example.model

class Hotel  {

	
	String hotelname
	String roomtype
	int bookings
	String toplace
	int totalrooms
	Date bookingdate
	
	int roomsleft
	
	
	static hasMany = [trip: Trip]
	
	
	//int getRoomsleft() { (totalrooms - (bookings+1)) }
	
	static constraints = {
		roomtype size: 1..1
		roomsleft nullable: true
	}
	
	static mapping = { 
		//datasource "mysql"
		//datasources(['mysql', 'DEFAULT'])
		roomsleft formula: 'TOTALROOMS - (BOOKINGS+1)'
	}
	
	String toString() {
		hotelname
	}
	
}
