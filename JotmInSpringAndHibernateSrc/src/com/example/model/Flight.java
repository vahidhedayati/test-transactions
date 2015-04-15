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

package com.example.model;

import java.util.Date;

public class Flight extends BaseObject
{
    private Long flightid;
    private String flightname;
    private String from;
    private String to;
    private Integer bookings;
    private Integer totalSeats;
    private Date flightdate;

    public Flight(){}

    public Flight(String flightname,
    		   String from,
               String to,
               Integer bookings,
               Integer totalSeats,
               Date flightdate){
    this.flightname = flightname;
    this.from = from;
    this.to = to;
    this.bookings = bookings;
    this.totalSeats = totalSeats;
    this.flightdate = flightdate;
    }

    public Integer getBookings() {
        return bookings;
    }

    public Date getFlightdate() {
        return flightdate;
    }

    public Long getFlightid() {
        return flightid;
    }

    public String getFlightname() {
        return flightname;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setBookings(Integer integer) {
        bookings = integer;
    }

    public void setFlightdate(Date date) {
        flightdate = date;
    }

    public void setFlightid(Long long1) {
        flightid = long1;
    }

    public void setFlightname(String string) {
        flightname = string;
    }

    public void setFrom(String string) {
        from = string;
    }

    public void setTo(String string) {
        to = string;
    }

    public void setTotalSeats(Integer integer) {
        totalSeats = integer;
    }

}
