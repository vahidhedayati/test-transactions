package com.example

import grails.transaction.Transactional

import com.example.exception.HotelNotFoundException
import com.example.model.BookingRequest
import com.example.model.Hotel


class HotelManagerService {
	
	@Transactional(rollbackFor=HotelNotFoundException.class)
	def reserveHotel(BookingRequest bookingRequest) throws HotelNotFoundException {
		Hotel hotel = getAvailableHotel(bookingRequest)
		//println "___ WE HAVE ${hotel} ${hotel.bookings} >>>>"
		if(hotel){
			hotel.bookings = hotel.bookings + 1
			if (!hotel.save(flush:true)) { 
				throw new HotelNotFoundException()
				//throw new Exception("Issue updating hotel")
			}
			log.info "HOTEL updated ${hotel} should be saved"
			return hotel
		}
		log.error "HotelManagerImpl : reserveHotel() - Hotel not available"
		throw new HotelNotFoundException()
		return
	}

	def getAvailableHotel(BookingRequest bookingRequest) {
		def hotels = Hotel.findByBookingdateAndToplaceAndRoomsleftGreaterThan(bookingRequest.traveldate,bookingRequest.to, 0)
		if (hotels){
			log.info "HotelManagerImpl : getAvailableHotel() - Got hotel........" + hotels.hotelname
			return hotels
		}
		return null
	}


}
