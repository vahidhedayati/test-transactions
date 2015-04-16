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

		boolean afail = false
		String failure = ''

		if (!flight) {
			failure = "TravelBrokerImpl : bookTrip() - NULL flight"
			afail = true
		}else{
			failure = "TravelBrokerImpl : bookTrip() -$flight booked"
		}

		if (!hotel) {
			failure = "TravelBrokerImpl : bookTrip() - NULL hotel"
			afail = true
		} else{
			failure = "TravelBrokerImpl : bookTrip() -  $hotel booked"
		}

		if (!car) {
			failure = "TravelBrokerImpl : bookTrip() - NULL car"
			afail = true
		}else{
			failure = "TravelBrokerImpl : bookTrip() - $car booked"
		}

		if (afail) {
			throw new TravelCompletionException()
			// throw new Exception("Exception thrown: ${failure}");
		}

		Trip trip =  new Trip(flight: flight, hotel: hotel, car: car)
		if (!trip.save(flush: true)) {
			throw new TravelCompletionException()
			//throw new Exception("Exception thrown: could not save trip")
		}

		if (afail) {
			return failure
		}else{
			return trip
		}
	}

}
