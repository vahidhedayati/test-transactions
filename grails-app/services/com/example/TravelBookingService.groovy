package com.example

import grails.transaction.Transactional

import com.example.exception.TravelCompletionException
import com.example.model.BookingRequest
import com.example.model.Trip
import com.example.other.Preinput
import com.example.other.Yac

@Transactional
class TravelBookingService {

	//Inject service
	def travelBrokerService

	@Transactional(rollbackFor=TravelCompletionException.class)
	public String bookAction(Date traveldate, String from, String to, String action) throws TravelCompletionException {
		StringBuilder output = new StringBuilder()
		
		
		// Insert count of preinput records - before doing any transactional stuff
		// If something goes wrong this should not appear to increment on the html page. 
		def csize = Preinput.list().size()
		Preinput pp = new Preinput(name: csize as String)
		if (!pp.save(flush:true)) {
			throw new TravelCompletionException()
		}
		
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

		Yac yc = new Yac(bookingId: bookingRequest.id, tripId: trip.id)
		if (!yc.save(flush:true)) {
			throw new TravelCompletionException()
		}
		
		
		output.append("${action}: "+ trip)
		return output
	}
}
