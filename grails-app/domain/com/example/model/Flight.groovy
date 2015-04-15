package com.example.model

class Flight {
	
    String flightname
    String from
    String to
    int bookings
    int totalSeats
    Date flightdate
	
	
	int seatsleft
	static transients = ['seatsleft']
	
	static mapping = {
		to column: '`to`'
		from column: '`from`'
		seatsleft formula: 'BOOKINS + 1 - TOTAL_SEATS'
	 }
	
	String toString() {
		flightname
	}
	
}
