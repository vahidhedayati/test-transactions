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
import java.lang.Character;

public class Hotel extends BaseObject
{
    private Long hotelid;
    private String hotelname;
    private Character roomtype;
    private Integer bookings;
    private String toplace;
    private Integer totalrooms;
    private Date bookingdate;

    public Hotel(){}

    public Hotel(String hotelname,
               Character roomtype,
               Integer bookings,
               String toplace,
               Integer totalrooms,
               Date bookingdate){
    this.hotelname = hotelname;
    this.roomtype = roomtype;
    this.bookings = bookings;
    this.toplace = toplace;
    this.totalrooms = totalrooms;
    this.bookingdate = bookingdate;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public Integer getBookings() {
        return bookings;
    }

    public Long getHotelid() {
        return hotelid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public String getToplace() {
        return toplace;
    }

    public Character getRoomtype() {
        return roomtype;
    }

    public Integer getTotalrooms() {
        return totalrooms;
    }

    public void setBookingdate(Date date) {
        bookingdate = date;
    }

    public void setBookings(Integer integer) {
        bookings = integer;
    }

    public void setHotelid(Long long1) {
        hotelid = long1;
    }

    public void setHotelname(String string) {
        hotelname = string;
    }

    public void setToplace(String string) {
        toplace = string;
    }

    public void setRoomtype(Character c) {
        roomtype = c;
    }

    public void setTotalrooms(Integer integer) {
        totalrooms = integer;
    }

}
