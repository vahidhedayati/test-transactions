package com.example.model

class BookingRequest {
	
    Date traveldate
    String to
    String from
	
	static mapping = {
		to column: '`to`'
		from column: '`from`'
	 }
	
	String toString() { 
		"${to} ${from} ${traveldate}"
	}
}
