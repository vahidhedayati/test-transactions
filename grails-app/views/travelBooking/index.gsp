
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'aa.label', default: 'aa')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
	
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
<table>
<tr><td>
<h1>Hotels</h1> <br/>
		<g:each in="${hotels }" var="hotel">
			${hotel.hotelname } | Booking:<b>${hotel.bookings}</b> | Total Rooms: ${hotel.totalrooms } | Left : ${hotel.roomsleft } <br/> 
		</g:each>

</td>
<td>
<h1>Flights</h1> <br/>

		<g:each in="${flights }" var="flight">
			${flight.flightname } | Booking: <b>${flight.bookings}</b> | Total Seats: ${flight.totalSeats }|Empty seats: ${flight.seatsleft } <br/> 
		</g:each>
</td></tr>
<tr>
<td>
<h1>Other DB Pre insert of any input</h1> <br/>

		<g:each in="${pp }" var="pa">
			${pa.name }  <br/>
		</g:each>

</td>
<td>
<h1>Bookings</h1> <br/>

		
		<g:each in="${bookings }" var="booking">
			${booking.traveldate } | From: ${booking.from } | To: ${booking.to } <br/>
		</g:each>
		</td>
		
		
		<td>

<h1>Yac</h1> <br/>

	<g:each in="${yac }" var="yc">
			${yc.bookingId } |  ${yc.tripId }<br/>
		</g:each>
		
		</td>
		
		
		
		</tr>

</table>
		
		
		<hr/>
		Holiday Dealz: Option 1 works the rest throw exceptions -   
		<g:form method="post" name="aa">
		<g:select from="${['1': 'Dallas To Cochin Working', '2': 'Singapore to Cochin', '3': 'Singapore to  California', '4':'NewYork to Delhi']}" optionKey="key" optionValue="value" name="choice" size="1"/>
		<g:submitButton name="submit" value="Book Super Dealz " class="submit"/>
		</g:form>
		<hr/>
		
		
		<h1>Output</h1>
		${output }
		
		
	
	</body>
</html>
	