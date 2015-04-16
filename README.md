### Grails tutorial on JOTM Transactions

In this tutorial I hope to be able to explain to a Java developer on how I have ported over 
[jotm-transactions-in-spring-and-hibernate.html](https://today.java.net/pub/a/today/2006/08/31/jotm-transactions-in-spring-and-hibernate.html) over to a grails application.


The provide the [actual source here](https://today.java.net/sites/all/modules/pubdlcnt/pubdlcnt.php?file=/today/2006/08/31/JotmInSpringAndHibernateSrc.zip&nid=219704). It can be found in this project under [JotmInSpringAndHibernateSrc folder](https://github.com/vahidhedayati/test-transactions/tree/master/JotmInSpringAndHibernateSrc).


This is what is sort of being achieved, at the moment I have not spread it over multiple Databases and only using internal DB as part of the test: (will use mysql in conjunction when I next get some time)


![BookingATrip](https://raw.github.com/vahidhedayati/test-transactions/master/images/Figure01_BookingATrip.jpg)



#### Java: Model / Grails: domainClass:

[BaseObject](https://github.com/vahidhedayati/test-transactions/blob/master/JotmInSpringAndHibernateSrc/src/com/example/model/BaseObject.java)
In this what would be domainClass is not a requirement for Grails. 

[BookingRequest.java](https://github.com/vahidhedayati/test-transactions/blob/master/JotmInSpringAndHibernateSrc/src/com/example/model/BookingRequest.java) converted to a domainClass in this demo Grails application: [BookingRequest.groovy](https://github.com/vahidhedayati/test-transactions/blob/master/grails-app/domain/com/example/model/BookingRequest.groovy)
 
You will notice it is rather plain has no getters and setters and missing other public declarations really not needed in the world of Grails as you will begin to see a little later.


I will touch on one more model : domainClass to explain an additional feature that could be explored in this lower level:
[Hotel.java](https://github.com/vahidhedayati/test-transactions/blob/master/JotmInSpringAndHibernateSrc/src/com/example/model/Hotel.java) ported over to domainClass: 
[Hotel.groovy](https://github.com/vahidhedayati/test-transactions/blob/master/grails-app/domain/com/example/model/Hotel.groovy)

In this domainClass you will notice:
```groovy
roomsleft formula: 'BOOKINS + 1 - TOTALROOMS'
```

This is something you will see later in the Java code happening within the code a little later in another class.



#### dao
[dao entire folder](https://github.com/vahidhedayati/test-transactions/tree/master/JotmInSpringAndHibernateSrc/src/com/example/dao)
This is not required in Grails. By default you have [DataSource.groovy](https://github.com/vahidhedayati/test-transactions/blob/master/grails-app/conf/DataSource.groovy) which is created when creating the app. The contents of this currently is the defaults being a JDBC connection for Hibernate to an internal H2 database.


#### exception:
[Java exception](https://github.com/vahidhedayati/test-transactions/tree/master/JotmInSpringAndHibernateSrc/src/com/example/exception) folder content ported over to Groovy here: [Groovy exception](https://github.com/vahidhedayati/test-transactions/tree/master/src/groovy/com/example/exception)


#### Java: service / Grails: services
In this Java [service](https://github.com/vahidhedayati/test-transactions/tree/master/JotmInSpringAndHibernateSrc/src/com/example/service) folder there are 4 interfaces in the base folder. None of these were required for this Grails app.

Service :[HotelManagerImpl.java](https://github.com/vahidhedayati/test-transactions/blob/master/JotmInSpringAndHibernateSrc/src/com/example/service/impl/HotelManagerImpl.java) was ported over to [HotelManagerService.groovy](https://github.com/vahidhedayati/test-transactions/blob/master/grails-app/services/com/example/HotelManagerService.groovy)

Now you will notice a lot of differences between these two classes. The groovy version does not appear to have a lot inside it. 

So the static content of this class:

```java
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
```

This all happens in another place in a Grails application. By default you are provided with a BootStrap.groovy in your conf folder. So you will find:

So in [BootStrap.groovy](https://raw.githubusercontent.com/vahidhedayati/test-transactions/master/grails-app/conf/BootStrap.groovy) you will see:
```groovy
Hotel hotel1 = Hotel.findOrSaveWhere(hotelname: "Sofitel", roomtype: 'A',  bookings: 0, toplace : "Cochin",  totalrooms: 10, 
			bookingdate: cDate(2005, 1, 1))
			
		Hotel hotel2 =  Hotel.findOrSaveWhere(hotelname: "The Ritz-Carlton", roomtype: 'A',  bookings: 0, toplace: "NewYork", totalrooms: 10, 
			bookingdate: cDate(2005, 1, 1))
		
		Hotel hotel3 =  Hotel.findOrSaveWhere(hotelname: "Affinia Dumont", roomtype: 'B',  bookings: 0, toplace: "Dallas",  totalrooms: 10, 
			bookingdate: cDate(2005, 1, 2))
			
		Hotel hotel4 =  Hotel.findOrSaveWhere(hotelname: "Trump International Hotel", roomtype: 'C', bookings: 0, toplace: "NewYork", totalrooms: 10, 
			bookingdate: cDate(2005, 1, 2))
			
		Hotel hotel5 =  Hotel.findOrSaveWhere(hotelname: "Hilton Times Square", roomtype: 'C',  bookings: 0, toplace: "California", totalrooms: 10, 
			bookingdate: cDate(2005, 1, 3))
			
		Hotel hotel6 =  Hotel.findOrSaveWhere(hotelname: "Singapore Square", roomtype: 'C',  bookings: 0, toplace: "Cochin", totalrooms: 10, 
			bookingdate: cDate(2005, 1, 3))
		
```


 
That covers that entire static block we don't actually use the arraryList defined in the static content either...

On line [103](https://github.com/vahidhedayati/test-transactions/blob/master/JotmInSpringAndHibernateSrc/src/com/example/service/impl/HotelManagerImpl.java#L103) of the Java code you will see a calculation for the db :

```java
&& (hotel.getBookings().intValue()+1) < hotel.getTotalrooms().intValue()){
```

which was the formula above
```groovy
roomsleft formula: 'BOOKINS + 1 - TOTALROOMS'
```
now defined with a much simpler query here:
[Line 27 HotelManagerService.groovy](https://github.com/vahidhedayati/test-transactions/blob/master/grails-app/services/com/example/HotelManagerService.groovy#L27)
```groovy
def hotels = Hotel.findByBookingdateAndToplaceAndRoomsleftGreaterThan(bookingRequest.traveldate,bookingRequest.to,0 )
```

Notice its taking advantage of our formula in the domainClass to make up the tricky bit..


#### Java: client / Grails: Controller

This is our final folder and well in this Java application it looks to be a CLI app asking user to make choices of 1..4. In the grails application I decided to create index1..4 and hitting each index page will carry out those options.

[TravelBookingClient.java](https://github.com/vahidhedayati/test-transactions/blob/master/JotmInSpringAndHibernateSrc/src/com/example/client/TravelBookingClient.java)
ported over to: [TravelBookingController.groovy](https://github.com/vahidhedayati/test-transactions/blob/master/grails-app/controllers/com/example/TravelBookingController.groovy) I am still to work on this whole thing not the tidies way of doing all of it just a quick test at the time...


Now back to excercise.

You can run:

```bash
git clone https://github.com/vahidhedayati/test-transactions.git
cd  test-transactions
```

If you are going to load it up in ggts then run:

```bash
 grails integrate-with --eclipse
```

You should now be able to load in the project in your workspace.

To continue running it command line: 
```bash
grails run-app
```

You will need grails 2.4.4 and you will need JDK 7+



### Testing the site

http://localhost:8080/test-transactions/travelBooking/index

Vahid'z Dealz: Option 1 works the rest throw exceptions - need to still work on this - 
		So click deal 1 ten times and it should then throw exception..  

Now the first index is me doing a wrapper around what the project is doing. It probably needs to list all of the domain classes - at the moment the hotel rooms are not going down need to look into that -- but the flights when it reaches 0 it don't let any more through - it provides a drop down chooce option 1 10 ten times and post it... each time the flights go down by 1 :

```
Sofitel | Bookings 1 | Rooms: 10 | Left : 9
The Ritz-Carlton | Bookings 0 | Rooms: 10 | Left : 10
Affinia Dumont | Bookings 0 | Rooms: 10 | Left : 10
Trump International Hotel | Bookings 0 | Rooms: 10 | Left : 10
Hilton Times Square | Bookings 0 | Rooms: 10 | Left : 10
Singapore Square | Bookings 0 | Rooms: 10 | Left : 10
Lufthansa | Bookings 10 | Rooms: 10 >> 0
Lufthansa | Bookings 0 | Rooms: 10 >> 10
Lufthansa | Bookings 0 | Rooms: 10 >> 10
Lufthansa | Bookings 0 | Rooms: 10 >> 10
Lufthansa | Bookings 0 | Rooms: 10 >> 10
Lufthansa | Bookings 0 | Rooms: 10 >> 10

I will Sofitel | Bookings 1 | Rooms: 10 | Left : 9
The Ritz-Carlton | Bookings 0 | Rooms: 10 | Left : 10
Affinia Dumont | Bookings 0 | Rooms: 10 | Left : 10
Trump International Hotel | Bookings 0 | Rooms: 10 | Left : 10
Hilton Times Square | Bookings 0 | Rooms: 10 | Left : 10
Singapore Square | Bookings 0 | Rooms: 10 | Left : 10
Lufthansa | Bookings 10 | Rooms: 10 >> 0
Lufthansa | Bookings 0 | Rooms: 10 >> 10
Lufthansa | Bookings 0 | Rooms: 10 >> 10
Lufthansa | Bookings 0 | Rooms: 10 >> 10
Lufthansa | Bookings 0 | Rooms: 10 >> 10
Lufthansa | Bookings 0 | Rooms: 10 >> 10
```

I will be working on this to show how transactions rolling back in this all or none situation.. if I can or if possible..

Other pages - this was the old manual demo I was using..

http://localhost:8080/test-transactions/travelBooking/index1 works


http://localhost:8080/test-transactions/travelBooking/index2 fails


http://localhost:8080/test-transactions/travelBooking/index3 fails


http://localhost:8080/test-transactions/travelBooking/index4 fails



#### Other useful Transactions links:

[grails transactions youtube Burt Beckwith](https://www.youtube.com/watch?v=JNey9T--rLE)

[grails-atomikos](https://github.com/grails-plugins/grails-atomikos)

[related stackoverflow question](http://stackoverflow.com/questions/29631963/grails-groovy-custom-transactional-exceptions)


[Grails-Transactions-Revisited](http://blog.perezalcolea.info/2014/06/09/Grails-Transactions-Revisited.html)

[Transaction & Batch-processing in Grails](http://sacharya.com/transactions-in-grails/)

