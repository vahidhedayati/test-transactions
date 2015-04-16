package com.example.model

class Flight {
	
    String flightname
    String from
    String to
    int bookings
    int totalSeats
    Date flightdate
	
	
	int seatsleft
	//static transients = ['seatsleft']
	
	static constraints = {
		seatsleft nullable: true
	}
	
	
	static mapping = {
		to column: '`to`'
		from column: '`from`'
		seatsleft formula: 'TOTAL_SEATS - BOOKINGS'
	 }
	
	String toString() {
		flightname
	}
	
}
