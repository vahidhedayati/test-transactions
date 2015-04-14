package com.example

import grails.transaction.Transactional

import com.example.exception.FlightNotFoundException
import com.example.model.BookingRequest
import com.example.model.Flight



class FlightManagerService {

	@Transactional
	def reserveFlight(BookingRequest bookingRequest) throws FlightNotFoundException {
		//println  "bookingRequest: ::0 >${bookingRequest}< ::1 >${bookingRequest.to}< ::2  >${bookingRequest.from}< ::3 >${bookingRequest.traveldate}<"
		Flight flight = getAvailableFlight(bookingRequest)
		if (!flight){
			throw new FlightNotFoundException("Flight not available");
		}
		flight.bookings = flight.bookings +1
		flight.save(flush:true)
		//flight.each { Flight fl ->
		//fl.bookings = fl.bookings +1
		//fl.save(flush:true)
		//}

		//println  "FLIGHT updated ${flight}"
		return flight
	}

	def getAvailableFlight(BookingRequest bookingRequest){
		// (bookings().intValue()+1) < totalSeats().intValue()
		//  && bookings < totalSeats
		def flights=Flight.withCriteria {
			eq ('from', bookingRequest.from)
			eq ('to',bookingRequest.to)
			eq ('flightdate',bookingRequest.traveldate)
			//lt ('bookings', 'totalSeats')
		}
		if (flights) {
			println "FlightManagerImpl : getAvailableFlight() - Got flight....." + flights[0].flightname
			return flights[0]
		}
		return null
	}

}
