/*
 * Copyright (c) 2006 Binildas A Christudas / Sowmya Hubert. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in
 *   the documentation and/or other materials provided with the
 *   distribution.
 *
 * Neither the name of the author, or the names of
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. AUTHOR AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL THE AUTHOR
 * OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR
 * FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR
 * PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF
 * LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE SOFTWARE,
 * EVEN IF THE AUTHOR HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that Software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of
 * any nuclear facility.
 */

package com.example.service.impl;

import com.example.service.CarManager;
import com.example.service.FlightManager;
import com.example.service.HotelManager;
import com.example.service.TravelBroker;
import com.example.model.Car;
import com.example.model.Flight;
import com.example.model.Hotel;
import com.example.model.Trip;
import com.example.model.BookingRequest;
import com.example.exception.TravelException;
import com.example.exception.TravelCompletionException;

public class TravelBrokerImpl implements TravelBroker{

    private FlightManager flightManager;
    private HotelManager hotelManager;
    private CarManager carManager;

	public void setFlightManager(FlightManager manager){
		flightManager = manager;
	}

	public void setHotelManager(HotelManager manager){
		hotelManager = manager;
	}

	public void setCarManager(CarManager manager){
		carManager = manager;
	}

	public Trip bookTrip(BookingRequest bookingRequest) throws TravelException{
		// Reserve flight
		Flight flight = flightManager.reserveFlight(bookingRequest);
		// Reserve hotel
		Hotel hotel = hotelManager.reserveHotel(bookingRequest);
		// Reserve car
		Car car = carManager.reserveCar(bookingRequest);
		if((null == flight) || (null == hotel) || (null == car)){
			System.out.println("TravelBrokerImpl : bookTrip() - ((null == flight) || (null == hotel) || (null == car))");
			throw new TravelCompletionException("((null == flight) || (null == hotel) || (null == car))");
		}
		//Return the trip
		return new Trip(flight, hotel, car);
	}

}
