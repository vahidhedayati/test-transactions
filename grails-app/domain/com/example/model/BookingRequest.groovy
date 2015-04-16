package com.example.model

class BookingRequest {
	
    Date traveldate
    String to
    String from
	
	static mapping = {
		//datasource "DEFAULT"
		to column: '`to`'
		from column: '`from`'
	 }
	
	String toString() { 
		"${to} ${from} ${traveldate}"
	}
}
