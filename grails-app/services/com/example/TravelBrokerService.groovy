package com.example

import com.example.exception.TravelCompletionException
import com.example.exception.TravelException
import com.example.model.BookingRequest
import com.example.model.Car
import com.example.model.Flight
import com.example.model.Hotel
import com.example.model.Trip


class TravelBrokerService {
	

	def flightManagerService
	def hotelManagerService
	def carManagerService
	
	public Trip bookTrip(BookingRequest bookingRequest) throws TravelException{
		// Reserve flight
		Flight flight = flightManagerService.reserveFlight(bookingRequest)
		// Reserve hotel
		Hotel hotel = hotelManagerService.reserveHotel(bookingRequest)
		// Reserve car
		Car car = carManagerService.reserveCar(bookingRequest)
		if ((!flight) || (!hotel) || (!car)) {
			 println "TravelBrokerImpl : bookTrip() - ((null == flight) || (null == hotel) || (null == car))"	 
			 throw new TravelCompletionException("((null == flight) || (null == hotel) || (null == car))");
		}
		Trip trip =  new Trip(flight: flight, hotel: hotel, car: car).save(flush:true)
		return trip 
	}
	
}
