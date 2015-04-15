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

package com.example.client;

import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.BookingRequest;
import com.example.model.Trip;
import com.example.service.TravelBroker;
import com.example.exception.TravelException;

public class TravelBookingClient{

    private static Log log = LogFactory.getLog(TravelBookingClient.class);
    private ApplicationContext ctx;
    private TravelBroker travelBrokerRequired;
    private TravelBroker travelBrokerRequireNew;

    public TravelBookingClient(){
        String[] paths = {"/applicationContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        travelBrokerRequired = (TravelBroker) ctx.getBean("travelBrokerRequired");
        travelBrokerRequireNew = (TravelBroker) ctx.getBean("travelBrokerRequiresNew");
    }

    public void finalize(){
        travelBrokerRequired = null;
        travelBrokerRequireNew = null;
    }

    public void CreateBooking(String arg) throws Exception {
        log("TravelBookingClient.CreateBooking() : Start...");

        BookingRequest bookingRequest = null;
        Trip trip = null;
        if (arg !=  null) {
            try{
				if("1".equals(arg)){
                    bookingRequest = new BookingRequest((new GregorianCalendar(2005, 1, 1)).getTime(), "Dallas", "Cochin");
                    trip = travelBrokerRequired.bookTrip(bookingRequest);
				}
				else if("2".equals(arg)){
                    bookingRequest = new BookingRequest((new GregorianCalendar(2005, 1, 3)).getTime(), "Singapore", "Cochin");
                    trip = travelBrokerRequired.bookTrip(bookingRequest);
				}
                else if("3".equals(arg)){
                    bookingRequest = new BookingRequest((new GregorianCalendar(2005, 1, 3)).getTime(), "Singapore", "Cochin");
                    trip = travelBrokerRequireNew.bookTrip(bookingRequest);
                }
                else if("4".equals(arg)){
                    bookingRequest = new BookingRequest((new GregorianCalendar(2005, 1, 2)).getTime(), "NewYork", "Delhi");
                    trip = travelBrokerRequireNew.bookTrip(bookingRequest);
                }
                else{
					log("Sorry! Request not identified. Try again...");
                }
            } catch (TravelException travelException){
                System.out.println(travelException.getMessage());
            }
        }

        log("TravelBookingClient.CreateBooking() : End...");
    }

    public static void main(String[] args)throws Exception{
        log("TravelBookingClient.main() : Start...");
        TravelBookingClient travelBookingClient = new TravelBookingClient();
        travelBookingClient.CreateBooking(args[0]);
        log("TravelBookingClient.main() : End...");
    }

    private static final void log(Object message){
        System.out.println(message.toString());
    }

}
