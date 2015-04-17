package com.example.model

class Car  {
	
	String carname
    String booked
    String from
    String to
    Date bookingdate
	
	static hasMany = [trip: Trip]
	
	static constraints = {
		booked size: 1..1
	}
	
	
	static mapping = {
		to column: '`to`'
		from column: '`from`'
	 }
	
	String toString() {
		carname
	}
}
