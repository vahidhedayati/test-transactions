package com.example.model

class Flight {
	
    String flightname
    String from
    String to
    Integer bookings
    Integer totalSeats
    Date flightdate
	
	static mapping = {
		to column: '`to`'
		from column: '`from`'
	 }
	
}
