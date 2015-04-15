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

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.example.dao.HotelDao;
import com.example.model.BookingRequest;
import com.example.model.Hotel;
import com.example.service.HotelManager;
import com.example.exception.HotelNotFoundException;

public class HotelManagerImpl implements HotelManager
{
    private static List hotelList;
    private HotelDao hotelDao;

    static{
        Hotel hotel1 = new Hotel("Sofitel", new Character('A'),  new Integer(0),"Cochin",  new Integer(10), (new GregorianCalendar(2005, 1, 1)).getTime());
        Hotel hotel2 = new Hotel("The Ritz-Carlton", new Character('A'),  new Integer(0),"NewYork", new Integer(10), (new GregorianCalendar(2005, 1, 1)).getTime());
        Hotel hotel3 = new Hotel("Affinia Dumont", new Character('B'),  new Integer(0),"Dallas",  new Integer(10), (new GregorianCalendar(2005, 1, 2)).getTime());
        Hotel hotel4 = new Hotel("Trump International Hotel", new Character('C'),  new Integer(0),"NewYork", new Integer(10), (new GregorianCalendar(2005, 1, 2)).getTime());
        Hotel hotel5 = new Hotel("Hilton Times Square", new Character('C'),  new Integer(0),"California", new Integer(10), (new GregorianCalendar(2005, 1, 3)).getTime());
        Hotel hotel6 = new Hotel("Singapore Square", new Character('C'),  new Integer(0),"Cochin", new Integer(10), (new GregorianCalendar(2005, 1, 3)).getTime());
        hotelList = new ArrayList();
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
        hotelList.add(hotel4);
        hotelList.add(hotel5);
        hotelList.add(hotel6);
    }

    public void setHotelDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

	public Hotel reserveHotel(BookingRequest bookingRequest) throws HotelNotFoundException
	{
		Hotel hotel = getAvailableHotel(bookingRequest);
		/*
		if (hotel == null){
			throw new HotelNotFoundException("Hotel not available");
		}
		*/
		if (hotel == null){
			System.out.println("HotelManagerImpl : reserveHotel() - Hotel not available");
		}
		if(null != hotel){
			hotel.setBookings(new Integer(1));
			hotelDao.reserveHotel(hotel);
		}
		return hotel;
	}

    public Hotel getAvailableHotel(BookingRequest bookingRequest)
    {
        /* Iterating through the list of available hotels.*/
        Iterator iterator = hotelList.iterator();
        while(iterator.hasNext()){
            Hotel hotel = (Hotel)iterator.next();
            /*Checks whether any hotels are available to serve the request.*/
            if (bookingRequest.getTraveldate().equals(hotel.getBookingdate())
                && bookingRequest.getTo().equalsIgnoreCase(hotel.getToplace())
                && (hotel.getBookings().intValue()+1) < hotel.getTotalrooms().intValue()){
                    System.out.println("HotelManagerImpl : getAvailableHotel() - Got hotel........" + hotel.getHotelname());
                    return hotel;
            }
        }
        return null;
    }
}
