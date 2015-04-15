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

public class Car extends BaseObject
{
    private Long carid;
    private String carname;
    private Character booked;
    private String from;
    private String to;
    private Date bookingdate;

    public Car(){}

    public Car(String carname,
               Character booked,
               String from,
               String to,
               Date bookingdate){
    this.carname = carname;
    this.booked = booked;
    this.from = from;
    this.to = to;
    this.bookingdate = bookingdate;
    }

    public Character getBooked() {
        return booked;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public Long getCarid() {
        return carid;
    }

    public String getCarname() {
        return carname;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setBooked(Character c) {
        booked = c;
    }

    public void setBookingdate(Date date) {
        bookingdate = date;
    }

    public void setCarid(Long long1) {
        carid = long1;
    }

    public void setCarname(String string) {
        carname = string;
    }

    public void setFrom(String string) {
        from = string;
    }

    public void setTo(String string) {
        to = string;
    }

}
