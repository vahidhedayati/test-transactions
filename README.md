### Grails tutorial on JOTM Transacations

This is a ported example provided in this Java tutorial found on this link:

[jotm-transactions-in-spring-and-hibernate.html](https://today.java.net/pub/a/today/2006/08/31/jotm-transactions-in-spring-and-hibernate.html)

The provide the [actual source here](https://today.java.net/sites/all/modules/pubdlcnt/pubdlcnt.php?file=/today/2006/08/31/JotmInSpringAndHibernateSrc.zip&nid=219704)


This is what is sort of being achieved, to be honest I have not spread it over multi DB's and only using internal DB as part of the test:


![BookingATrip](https://raw.github.com/vahidhedayati/test-transactions/master/images/Figure01_BookingATrip.jpg)



http://localhost:8080/test-transactions/travelBooking/index1 works


http://localhost:8080/test-transactions/travelBooking/index2 fails


http://localhost:8080/test-transactions/travelBooking/index3 fails


http://localhost:8080/test-transactions/travelBooking/index4 fails
