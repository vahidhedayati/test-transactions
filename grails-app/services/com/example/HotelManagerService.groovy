package com.example

import grails.transaction.Transactional

import com.example.exception.HotelNotFoundException
import com.example.model.BookingRequest
import com.example.model.Hotel


class HotelManagerService {
	
	@Transactional(rollbackFor=HotelNotFoundException.class)
	def reserveHotel(BookingRequest bookingRequest) throws HotelNotFoundException {
		Hotel hotel = getAvailableHotel(bookingRequest)
		if(hotel){
			hotel.bookings =  +1
			hotel.save(flush:true)
			println "HOTEL updated ${hotel} should be saved"
			return hotel
		}

		log.error "HotelManagerImpl : reserveHotel() - Hotel not available"
		return null
	}

	def getAvailableHotel(BookingRequest bookingRequest) {
		def hotels = Hotel.findByBookingdateAndToplaceAndRoomsleftGreaterThan(bookingRequest.traveldate,bookingRequest.to,0 )
		if (hotels){
			println "HotelManagerImpl : getAvailableHotel() - Got hotel........" + hotels.hotelname
			return hotels
		}
		return null
	}


}
