
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'aa.label', default: 'aa')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>

		<g:each in="${hotels }" var="hotel">
			${hotel.hotelname } | Bookings ${hotel.bookings } | Rooms: ${hotel.totalrooms } | Left : ${hotel.roomsleft } <br/> 
		</g:each>
		
		<g:each in="${flights }" var="flight">
			${flight.flightname } | Bookings ${flight.bookings } | Rooms: ${flight.totalSeats } >> ${flight.seatsleft } <br/> 
		</g:each>
		
		
		<g:each in="${bookingrequests }" var="bookings">
			${bookingrequests.traveldate } : ${bookingrequests.to } : ${bookingrequests.from }
		</g:each>
		
		<hr/>
		Vahid'z Dealz: Option 1 works the rest throw exceptions - need to still work on this - 
		So click deal 1 ten times and it should then throw exception..  
		<g:form method="post" name="aa">
		<g:select from="${['1': 'My Super deal 1 - which works', '2': '2', '3': 'choice 3', '4':'choice4']}" optionKey="key" optionValue="value" name="choice" size="1"/>
		<g:submitButton name="submit" value="Book Super Dealz "/>
		</g:form>
		<hr/>
		<h1>Output</h1>
		${output }
		
		
	
	</body>
</html>
	