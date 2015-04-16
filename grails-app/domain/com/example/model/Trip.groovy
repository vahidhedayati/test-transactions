package com.example.model

class Trip  {
	
   Flight flight
   Hotel hotel
   Car car
   
   String toString() {
	   "${flight} ${hotel} ${car}" 
   }
   static mapping = {
	 //  datasources(['mysql', 'DEFAULT'])
	  // datasource 'ALL'
   }
   
}
