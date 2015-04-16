package com.example

import grails.transaction.Transactional

import com.example.exception.TravelCompletionException
import com.example.model.BookingRequest
import com.example.model.Trip

@Transactional
class TravelBookingService {

	//Inject service
	def travelBrokerService

	@Transactional(rollbackFor=TravelCompletionException.class)
	public String bookAction(Date traveldate, String from, String to, String action) throws TravelCompletionException {
		StringBuilder output = new StringBuilder()
		BookingRequest bookingRequest = new BookingRequest(traveldate: traveldate, from: from, to: to)
		
		if (!bookingRequest.save(flush:true)) { 
			throw new TravelCompletionException()	
		}
		
		Trip trip
		if (bookingRequest) {
			trip = travelBrokerService.bookTrip(bookingRequest)
		}

		if ((!bookingRequest) ||(!trip)) {
			//throw new Exception("((null == trip)");
			throw new TravelCompletionException()
		}

		output.append("${action}: "+ trip)
		return output
	}
}
