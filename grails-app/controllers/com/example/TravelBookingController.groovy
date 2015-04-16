package com.example

import com.example.exception.CarNotFoundException
import com.example.exception.FlightNotFoundException
import com.example.exception.TravelCompletionException
import com.example.exception.TravelException
import com.example.model.BookingRequest
import com.example.model.Flight
import com.example.model.Hotel


class TravelBookingController {
	

	def travelBookingService
	
	def index(String choice) {
		 String output=''
		try { 
		if (choice == "1") {
			output = travelBookingService.bookAction(cDate(2005, 1, 1), "Dallas", "Cochin", "index1")
		} else if (choice == "2") {
			output = travelBookingService.bookAction(cDate(2005, 1, 3), "Singapore", "Cochin", "index2")
		} else if (choice == "3") {
			output = travelBookingService.bookAction(cDate(2005, 1, 3), "Singapore", "California", "index3")
		} else if (choice == "4") {
			output = travelBookingService.bookAction(cDate(2005, 1, 2), "NewYork", "Delhi", "index4")
		}
		}catch(Exception|TravelCompletionException|CarNotFoundException|FlightNotFoundException|TravelException e) {
			flash.message = [message(code: 'booking.validation.error.message', 
				args: [org.apache.commons.lang.exception.ExceptionUtils.getRootCauseMessage(e)], 
				default: "The Booking changes did not pass validation.<br/>{0}")]
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
