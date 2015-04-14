package com.example

import grails.transaction.Transactional

import com.example.exception.CarNotFoundException
import com.example.model.BookingRequest
import com.example.model.Car


class CarManagerService {

	@Transactional
	def reserveCar(BookingRequest bookingRequest)throws CarNotFoundException {
		Car car = getExactCar(bookingRequest)
		if (!car){
			car = getAvailableCar(bookingRequest)
		}
		if (car) {
			car.save(flush:true)
			Calendar checkDate = Calendar.getInstance()
			checkDate.setTime(bookingRequest.getTraveldate())
			checkDate.add(Calendar.DAY_OF_MONTH,1)
			if (car.bookingdate.compareTo(checkDate.getTime())>0) {
				throw new CarNotFoundException("Car date does not match.")
			}

			return car
		}
	}

	def getAvailableCar(BookingRequest bookingRequest) {
		def cars = Car.findAllByToAndBooked(bookingRequest.getTo(), 'N')
		if (cars) {
			println "CarManagerImpl : getAvailableCar() - Got available car......" + cars[0].carname
			return cars[0]
		}
		return null
	}

	def getExactCar(BookingRequest bookingRequest) {
		def cars = Car.findAllByToAndBookedAndBookingdate(bookingRequest.getTo(), 'Y', bookingRequest.getTraveldate())
		if (cars) {
			println "CarManagerImpl : getExactCar() - Got exact car......" + cars[0].carname
			return cars[0]
		}
		return null
	}

}
