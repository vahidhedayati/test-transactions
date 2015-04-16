package com.example

import com.example.model.BookingRequest
import com.example.model.Flight
import com.example.model.Hotel


class TravelBookingController {
	

	def travelBookingService
	
	def index(String choice) {
		 String output=''
		if (choice == "1") {
			output = travelBookingService.bookAction(cDate(2005, 1, 1), "Dallas", "Cochin", "index1")
		} else if (choice == "2") {
			output =travelBookingService.bookAction(cDate(2005, 1, 3), "Singapore", "Cochin", "index2")
		} else if (choice == "3") {
			output = travelBookingService.bookAction(cDate(2005, 1, 3), "Singapore", "Cochin", "index3")
		} else if (choice == "4") {
			output = travelBookingService.bookAction(cDate(2005, 1, 2), "NewYork", "Cochin", "index4")
		}
			
		render view: 'index', model:[ hotels: Hotel.list(), flights: Flight.list(), bookings: BookingRequest.list(), output: output ] 
		
	}
	
	def index1() {
		render travelBookingService.bookAction(cDate(2005, 1, 1), "Dallas", "Cochin", "index1")
	}
	
	def index2() {
		render travelBookingService.bookAction(cDate(2005, 1, 3), "Singapore", "Cochin", "index2") 
	}

	
	def index3() {
		render travelBookingService.bookAction(cDate(2005, 1, 3), "Singapore", "Cochin", "index3")
	}

	
	def index4() {
		render travelBookingService.bookAction(cDate(2005, 1, 2), "NewYork", "Cochin", "index4")

	}
	
	private Date cDate(int year, int month, int day) {
		return (new GregorianCalendar(year, month, day)).time
	}

}
