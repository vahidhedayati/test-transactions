package com.example

import grails.transaction.Transactional

import com.example.exception.FlightNotFoundException
import com.example.model.BookingRequest
import com.example.model.Flight



class FlightManagerService {

	@Transactional(rollbackFor=FlightNotFoundException.class)
	def reserveFlight(BookingRequest bookingRequest) throws FlightNotFoundException {
		//println  "bookingRequest: ::0 >${bookingRequest}< ::1 >${bookingRequest.to}< ::2  >${bookingRequest.from}< ::3 >${bookingRequest.traveldate}<"
		Flight flight = getAvailableFlight(bookingRequest)
		if (!flight){
			throw new FlightNotFoundException("Flight not available")
		}
		flight.bookings = flight.bookings +1
		
		if (!flight.save(flush:true)) {
			throw new FlightNotFoundException("Issue updating flight")
		}
		
		//println  "FLIGHT updated ${flight}"
		return flight
	}
	
	def getAvailableFlight(BookingRequest bookingRequest){
		
		Flight flights = Flight.findByFromAndToAndFlightdateAndSeatsleftGreaterThan(bookingRequest.from, bookingRequest.to, bookingRequest.traveldate, 0 )
		//Flight flights = Flight.findByFromAndToAndFlightdate(bookingRequest.from, bookingRequest.to, bookingRequest.traveldate )
		if (flights) {
			println "FlightManagerImpl : getAvailableFlight() - Got flight....." + flights.flightname
			return flights
		}
		return null
	}

}
