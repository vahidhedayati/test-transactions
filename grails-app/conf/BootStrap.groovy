import com.example.model.Car
import com.example.model.Flight
import com.example.model.Hotel


class BootStrap {

    def init = { servletContext ->

		Car car1 = Car.findOrSaveWhere(carname: "car1", booked: 'Y',  
			from: "Cochin", to: "Cochin", bookingdate: cDate(2005, 1, 1))
		
		Car car2 =Car.findOrSaveWhere(carname: "car2", booked: 'N',  
			from: "NewYork", to: "NewYork", bookingdate:  cDate(2005, 1, 1))
			
		Car car3 = Car.findOrSaveWhere(carname: "car3", booked: 'N',  
			from: "Dallas", to: "Dallas", bookingdate:  cDate(2005, 1, 2))
			
		Car car4 = Car.findOrSaveWhere(carname: "car4", booked: 'Y',  
			from: "Delhi", to: "Delhi", bookingdate:  cDate(2005, 1, 2))
			
		Car car5 = Car.findOrSaveWhere(carname: "car5", booked: 'N',  
			from: "California", to: "California", bookingdate:  cDate(2005, 1, 5))
			
		Car car6 = Car.findOrSaveWhere(carname: "car5", booked: 'N',  
			from: "California", to: "California", bookingdate:  cDate(2005, 1, 5))
			

			/*
			 * traveldate: (new GregorianCalendar(2005, 1, 1)).getTime(), to: "Dallas", from: "Cochin")
			 */
			
		Flight flight1 = Flight.findOrSaveWhere(flightname: "Lufthansa", from: "Dallas", to: "Cochin", bookings: 0, totalSeats: 10, 
			flightdate: cDate(2005, 1, 1), seatsleft: 10)
			
		Flight flight2 =  Flight.findOrSaveWhere(flightname: "Lufthansa", from: "NewYork", to: "Chennai", bookings: 0, totalSeats: 10, 
			flightdate: cDate(2005, 1, 1), seatsleft: 10)
			
		Flight flight3 = Flight.findOrSaveWhere(flightname: "Lufthansa", from: "Dallas", to: "Singapore", bookings: 0, totalSeats: 10, 
			flightdate: cDate(2005, 1, 2), seatsleft: 10)
			
		Flight flight4 =  Flight.findOrSaveWhere(flightname: "Lufthansa", from: "NewYork", to: "Delhi", bookings: 0, totalSeats: 10, 
			flightdate:cDate(2005, 1, 2), seatsleft: 10)
			
		Flight flight5 = Flight.findOrSaveWhere(flightname: "Lufthansa", from: "California", to: "Cochin", bookings: 0, totalSeats: 10, 
			flightdate: cDate(2005, 1, 3), seatsleft: 10)
			
		Flight flight6 =  Flight.findOrSaveWhere(flightname: "Lufthansa", from: "Singapore", to: "Cochin", bookings: 0, totalSeats: 10, 
			flightdate: cDate(2005, 1, 3), seatsleft: 10)
		
			
			
		

		Hotel hotel1 = Hotel.findOrSaveWhere(hotelname: "Sofitel", roomtype: 'A',  bookings: 0, toplace : "Cochin",  totalrooms: 10, 
			bookingdate: cDate(2005, 1, 1), roomsleft: 10)
			
		Hotel hotel2 =  Hotel.findOrSaveWhere(hotelname: "The Ritz-Carlton", roomtype: 'A',  bookings: 0, toplace: "NewYork", totalrooms: 10, 
			bookingdate: cDate(2005, 1, 1), roomsleft: 10)
		
		Hotel hotel3 =  Hotel.findOrSaveWhere(hotelname: "Affinia Dumont", roomtype: 'B',  bookings: 0, toplace: "Dallas",  totalrooms: 10, 
			bookingdate: cDate(2005, 1, 2), roomsleft: 10)
			
		Hotel hotel4 =  Hotel.findOrSaveWhere(hotelname: "Trump International Hotel", roomtype: 'C', bookings: 0, toplace: "NewYork", totalrooms: 10, 
			bookingdate: cDate(2005, 1, 2), roomsleft: 10)
			
		Hotel hotel5 =  Hotel.findOrSaveWhere(hotelname: "Hilton Times Square", roomtype: 'C',  bookings: 0, toplace: "California", totalrooms: 10, 
			bookingdate: cDate(2005, 1, 3), roomsleft: 10)
			
		Hotel hotel6 =  Hotel.findOrSaveWhere(hotelname: "Singapore Square", roomtype: 'C',  bookings: 0, toplace: "Cochin", totalrooms: 10, 
			bookingdate: cDate(2005, 1, 3), roomsleft: 10)
		
		
    }
    def destroy = {
    }
	
	private Date cDate(int year, int month, int day) {
		return (new GregorianCalendar(year, month, day)).time
	}
}
