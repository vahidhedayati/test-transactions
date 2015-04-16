package com.example

import grails.transaction.Transactional

import com.example.exception.CarNotFoundException
import com.example.model.BookingRequest
import com.example.model.Car


class CarManagerService {

	@Transactional
	def reserveCar(BookingRequest bookingRequest) throws CarNotFoundException {
		Car car = getExactCar(bookingRequest)
		if (!car){
			car = getAvailableCar(bookingRequest)
		}
		if (car) {
			
			//if (!car.save(flush:true)) {
			//	throw new CarNotFoundException("Issue updating car")
			//}
			
			
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
		Car cars = Car.findByToAndBooked(bookingRequest.getTo(), 'N')
		if (cars) {
			println "CarManagerImpl : getAvailableCar() - Got available car......" + cars.carname
			return cars
		}
		return null
	}

	def getExactCar(BookingRequest bookingRequest) {
		Car cars = Car.findByToAndBookedAndBookingdate(bookingRequest.getTo(), 'Y', bookingRequest.getTraveldate())
		if (cars) {
			println "CarManagerImpl : getExactCar() - Got exact car......" + cars.carname
			return cars
		}
		return null
	}

}
