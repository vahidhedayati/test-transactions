package com.example.model

class Flight {
	
    String flightname
    String from
    String to
    int bookings
    int totalSeats
    Date flightdate
	
	int seatsleft
	
	static hasMany = [trip: Trip]
	
	static constraints = {
		seatsleft nullable: true
	}
	
	static mapping = {
		to column: '`to`'
		from column: '`from`'
		seatsleft formula: 'TOTAL_SEATS - (BOOKINGS+1)'
	 }
	
	String toString() {
		flightname
	}
	
}
