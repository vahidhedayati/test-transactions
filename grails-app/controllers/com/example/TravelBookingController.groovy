package com.example


class TravelBookingController {
	

	def travelBookingService
	
	def index1() {
		render travelBookingService.bookAction(cDate(2005, 1, 1), "Dallas", "Cochin", "index1")
	}
	
	def index2() {
		render travelBookingService.bookAction(cDate(2005, 1, 3), "Singapore", "Cochin", "index2") 
	}

	
	def index3() {
		render travelBookingService.bookAction(cDate(2005, 1, 3), "Singapore", "Cochin", "index3")
	}

	
	def index4() {
		render travelBookingService.bookAction(cDate(2005, 1, 2), "NewYork", "Cochin", "index4")

	}
	
	private Date cDate(int year, int month, int day) {
		return (new GregorianCalendar(year, month, day)).getTime()
	}

}
