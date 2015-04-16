package com.example

import grails.transaction.Transactional

import com.example.exception.TravelCompletionException
import com.example.model.BookingRequest
import com.example.model.Car
import com.example.model.Flight
import com.example.model.Hotel
import com.example.model.Trip


class TravelBrokerService {
	
	//Inject other services
	def flightManagerService
	def hotelManagerService
	def carManagerService
	
	@Transactional(rollbackFor=TravelCompletionException.class)
	public Trip bookTrip(BookingRequest bookingRequest) throws TravelCompletionException {
		// Reserve flight
		Flight flight = flightManagerService.reserveFlight(bookingRequest)
		// Reserve hotel
		Hotel hotel = hotelManagerService.reserveHotel(bookingRequest)
		// Reserve car
		Car car = carManagerService.reserveCar(bookingRequest)
		if ((!flight) || (!hotel) || (!car)) {
			
			if (!flight) {
				println "TravelBrokerImpl : bookTrip() - NULL flight"
			}
			
			if (!hotel) {
				println "TravelBrokerImpl : bookTrip() - NULL hotel"
			}
			
			if (!car) {
				println "TravelBrokerImpl : bookTrip() - NULL car"
			}
			
			 throw new TravelCompletionException("((null == flight) || (null == hotel) || (null == car))")
		}
		
		Trip trip =  new Trip(flight: flight, hotel: hotel, car: car).save(failOnError: true, flush: true)
		return trip 
	}
	
}
