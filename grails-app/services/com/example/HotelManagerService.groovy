package com.example

import grails.transaction.Transactional

import com.example.exception.HotelNotFoundException
import com.example.model.BookingRequest
import com.example.model.Hotel


class HotelManagerService {

	@Transactional
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
		//(bookings().intValue()+1) < totalrooms().intValue()
		def hotels=Hotel.withCriteria {
			eq ('bookingdate', bookingRequest.traveldate)
			eq ('toplace',bookingRequest.to)
			//lt ('bookings', 'totalrooms')
			//(bookings().intValue()+1) < totalrooms().intValue()
		}
		/*
		 def hotels = Hotel.where {
		 bookingdate == bookingRequest.traveldate && 
		 toplace == bookingRequest.to 
		 }
		 */
		if (hotels){
			println "HotelManagerImpl : getAvailableHotel() - Got hotel........" + hotels[0].hotelname
			return hotels[0]
		}
		return null
	}


}