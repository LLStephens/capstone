<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );

  function getDate() {
      document.getElementById("datepicker").val();
  }
</script>

<!-- calandar picker -->
<c:url var="patientView" value="/patientView"/>
<form method="GET" action="${patientView}">
	Select Date: <input name="date" id="datepicker" /> <input type="hidden"
		name="doctorId" value="${doctor.id}"> <input type="submit"
		value="Submit">
</form>

<br>

<div class="container col-xs-12 col-sm-3 zeros alignmid">
	<div class="col-xs-12 " id="doctorSideBar">
		<img style="width: 150px" class="doctorImg"
			src="img/doctors/${doctor.id}.jpg" /><br>
		<c:out value="Hello, I'm ${doctor.name}," />
		<c:out value="I'm looking forward to meeting you!" />
	</div>
</div>

<!-- this is the production of all the clickable schedule blocks -->
<div class="ol-xs-12 col-sm-9 alignmid ">
	<div class="col-xs-12 ">
		<c:url var="appointment" value="/doctorsAppointment" />
		<c:set var="counter" value="0" />
		
		<c:forEach var="index" begin="0" end="${fn:length(agenda)-1}">
			<c:choose>
			
				<c:when test="${(!empty apptTimes[counter]) && agenda[index].equals(apptTimes[counter])}">
					<div class="col-xs-12 unavailable">						
							<button >
								<c:out value="Booked"></c:out>
							</button>
					</div>
					<c:set var="counter" value="${counter + 1}" />
				</c:when>
				
				<c:otherwise>
				
					<c:url var="formAction2" value="/patientScheduling">
					</c:url>
					
					<div class="col-xs-12 " >
					<form method="GET" action="${formAction2}">
						<button class="open" style="width: 100%; height: 100%">
							<c:out value="${agenda[index]} - open" />
						</button>
						<input type="hidden" name="time" value = "${agenda[index]}"/>
						<input type="hidden" name="id" value="${index}" />
						<input type="hidden" name="date" value="${date}" />
						<input type="hidden" name="doctorId" value="${doctor.id}" />
					</form>
						
					</div>
		
				</c:otherwise>
				
			</c:choose>
		</c:forEach>
		
	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />