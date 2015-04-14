package com.example

import com.example.exception.TravelException
import com.example.model.BookingRequest
import com.example.model.Trip

class TravelBookingController {
	
	def travelBrokerService
	private BookingRequest bookingRequest
	private Trip trip 
	
	def index1() {
		StringBuilder output = new StringBuilder()
		try {
			bookingRequest = new BookingRequest(traveldate: (new GregorianCalendar(2005, 1, 1)).getTime(), from: "Dallas", to: "Cochin")
			trip = travelBrokerService.bookTrip(bookingRequest)
			output.append("1: "+ trip)
		} catch (TravelException travelException){
			output.append(travelException.getMessage())
		}
		render output.toString() 
	}
	
	def index2() {
		StringBuilder output = new StringBuilder()
		try {
			bookingRequest = new BookingRequest(traveldate: (new GregorianCalendar(2005, 1, 3)).getTime(), from: "Singapore", to: "Cochin")
			trip = travelBrokerService.bookTrip(bookingRequest)
			output.append("2: "+ trip)
		} catch (TravelException travelException){
			output.append(travelException.getMessage())
		}
		render output.toString() 
	}

	
	def index3() {
		StringBuilder output = new StringBuilder()
		try {
			bookingRequest = new BookingRequest(traveldate: (new GregorianCalendar(2005, 1, 3)).getTime(), from: "Singapore", to: "Cochin")
			trip = travelBrokerService.bookTrip(bookingRequest)
			output.append("3: "+ trip)

		} catch (TravelException travelException){
			output.append(travelException.getMessage())
		}
		render output.toString() 
	}

	
	def index4() {
		StringBuilder output = new StringBuilder()
		try {
			bookingRequest = new BookingRequest(traveldate: (new GregorianCalendar(2005, 1, 2)).getTime(), from: "NewYork", to: "Delhi")
			trip = travelBrokerService.bookTrip(bookingRequest)
			output.append("4: "+ trip)
		} catch (TravelException travelException){
			output.append(travelException.getMessage())
		}
		render output.toString() 
	}

}
