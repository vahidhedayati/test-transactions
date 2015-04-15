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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.example.dao.CarDao;
import com.example.model.BookingRequest;
import com.example.model.Car;
import com.example.service.CarManager;
import com.example.exception.CarNotFoundException;

public class CarManagerImpl implements CarManager
{
    private static List carList;
    private CarDao carDao;

    static{
        Car car1 = new Car("car1", new Character('Y'),  "Cochin", "Cochin",  (new GregorianCalendar(2005, 1, 1)).getTime());
        Car car2 = new Car("car2", new Character('N'),  "NewYork", "NewYork", (new GregorianCalendar(2005, 1, 1)).getTime());
        Car car3 = new Car("car3", new Character('N'),  "Dallas", "Dallas",  (new GregorianCalendar(2005, 1, 2)).getTime());
        Car car4 = new Car("car4", new Character('Y'),  "Delhi", "Delhi", (new GregorianCalendar(2005, 1, 2)).getTime());
		Car car5 = new Car("car5", new Character('N'),  "Cochin", "Cochin", (new GregorianCalendar(2005, 1, 5)).getTime());
		Car car6 = new Car("car6", new Character('N'),  "California", "California", (new GregorianCalendar(2005, 1, 3)).getTime());
        carList = new ArrayList();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
    }

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

	public Car reserveCar(BookingRequest bookingRequest)throws CarNotFoundException
	{
		Car car = getExactCar(bookingRequest);
		if (car == null){
			car = getAvailableCar(bookingRequest);
		}
		carDao.reserveCar(car);
		Calendar checkDate = Calendar.getInstance();
		checkDate.setTime(bookingRequest.getTraveldate());
		checkDate.add(Calendar.DAY_OF_MONTH,1);
		if (car.getBookingdate().compareTo(checkDate.getTime())>0)
			throw new CarNotFoundException("Car date does not match.");
		return car;
	}

    private Car getAvailableCar(BookingRequest bookingRequest)
    {
        /* Iterating through the list of available cars.*/
        Iterator iterator = carList.iterator();
        while(iterator.hasNext()){
            Car car = (Car)iterator.next();
            /*Checks whether any cars in the area are available to serve the request.*/
            if (bookingRequest.getTo().equalsIgnoreCase(car.getTo())
                && ("N".equalsIgnoreCase(car.getBooked().toString()))){
                    System.out.println("CarManagerImpl : getAvailableCar() - Got available car......" + car.getCarname());
                    return car;
            }
        }
        return null;
    }

	private Car getExactCar(BookingRequest bookingRequest)
	{
		/* Iterating through the list of available cars.*/
		Iterator iterator = carList.iterator();
		while(iterator.hasNext()){
			Car car = (Car)iterator.next();
			/*Checks whether any cars are available to serve the request.*/
			if (bookingRequest.getTraveldate().equals(car.getBookingdate())
				&& bookingRequest.getTo().equalsIgnoreCase(car.getTo())
				&& ("Y".equalsIgnoreCase(car.getBooked().toString()))){
					System.out.println("CarManagerImpl : getExactCar() - Got exact car......" + car.getCarname());
					return car;
			}
		}
		return null;
	}
}
