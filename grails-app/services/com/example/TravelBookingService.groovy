package com.example

import grails.transaction.Transactional

import com.example.exception.TravelException
import com.example.model.BookingRequest
import com.example.model.Trip

@Transactional
class TravelBookingService {
	
	//Inject service
	def travelBrokerService

	@Transactional(rollbackFor=TravelException.class)
	public String bookAction(Date traveldate, String from, String to, String action) throws TravelException{
		StringBuilder output = new StringBuilder()
		BookingRequest bookingRequest = new BookingRequest(traveldate: traveldate, from: from, to: to)
		Trip trip = travelBrokerService.bookTrip(bookingRequest)
		output.append("${action}: "+ trip)
		return output
	}
}
