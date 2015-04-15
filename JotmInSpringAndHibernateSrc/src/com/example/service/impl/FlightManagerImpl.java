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

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.example.dao.FlightDao;
import com.example.model.BookingRequest;
import com.example.model.Flight;
import com.example.service.FlightManager;
import com.example.exception.FlightNotFoundException;

public class FlightManagerImpl implements FlightManager
{
    private static List flightList;
    private FlightDao flightDao;

    static{
        Flight flight1 = new Flight( "Lufthansa", "Dallas", "Cochin", new Integer(0), new Integer(10), (new GregorianCalendar(2005, 1, 1)).getTime());
        Flight flight2 = new Flight( "Lufthansa", "NewYork", "Chennai", new Integer(0), new Integer(10), (new GregorianCalendar(2005, 1, 1)).getTime());
        Flight flight3 = new Flight( "Lufthansa", "Dallas", "Singapore", new Integer(0), new Integer(10), (new GregorianCalendar(2005, 1, 2)).getTime());
        Flight flight4 = new Flight( "Lufthansa", "NewYork", "Delhi", new Integer(0), new Integer(10), (new GregorianCalendar(2005, 1, 2)).getTime());
        Flight flight5 = new Flight( "Lufthansa", "California", "Cochin", new Integer(0), new Integer(10), (new GregorianCalendar(2005, 1, 3)).getTime());
        Flight flight6 = new Flight( "Lufthansa", "Singapore", "Cochin", new Integer(0), new Integer(10), (new GregorianCalendar(2005, 1, 3)).getTime());
        flightList = new ArrayList();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);
        flightList.add(flight6);
    }

    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

	public Flight reserveFlight(BookingRequest bookingRequest) throws FlightNotFoundException
	{
		Flight flight = getAvailableFlight(bookingRequest);
		if (flight == null){
			throw new FlightNotFoundException("Flight not available");
		}
      	flight.setBookings(new Integer(1));
		flightDao.reserveFlight(flight);
		return flight;
	}

    private Flight getAvailableFlight(BookingRequest bookingRequest)
    {
        /* Iterating through the list of available flights.*/
        Iterator iterator = flightList.iterator();
        int count = 0;
        while(iterator.hasNext()){
            Flight flight = (Flight)iterator.next();
            /*Checks whether any flights are available to serve the request.*/
            if (bookingRequest.getTraveldate().equals(flight.getFlightdate())
                && bookingRequest.getTo().equalsIgnoreCase(flight.getTo())
                && bookingRequest.getFrom().equalsIgnoreCase(flight.getFrom())
                && (flight.getBookings().intValue()+1) < flight.getTotalSeats().intValue()){
                    System.out.println("FlightManagerImpl : getAvailableFlight() - Got flight....." + flight.getFlightname());
                    return flight;
            }
        }
        return null;
    }
}
