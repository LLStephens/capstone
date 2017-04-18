<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		/* $( "#datepicker" ).datepicker(); */
		$("#datepicker").datepicker({
			minDate : 0,
			maxDate : "+6m",
			beforeShowDay : $.datepicker.noWeekends
		});
	});
</script>

<div class="container col-xs-12 col-sm-3 zeros sidebar">
	<div class="col-xs-12 " id="doctorSideBar">
		<img style="width: 150px" class="doctorImg"
			src="img/doctors/${doctor.id}.jpg" /><br>
		<h4>
			<c:out value="Hello, I'm ${doctor.name}." />
			<br>
			<c:out value="I'm looking forward to seeing you!" />
		</h4>
	</div>
</div>
<div class="col-xs-12 col-sm-9 alignmid ">
	<c:url var="patientView" value="/patientView" />
	<form method="GET" action="${patientView}">
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
		Select Date: <input name="date" id="datepicker" /> <input
			type="hidden" name="doctorId" value="${doctor.id}"> <input
			type="submit" value="Submit">
	</form>
	<h4>
		The schedule for:
		<tags:localDate date="${date}" pattern="MM/dd/yyyy" />
	</h4>
	<c:url var="appointment" value="/doctorsAppointment" />
	<c:set var="counter" value="0" />
	<c:forEach var="index" begin="0" end="${fn:length(agenda)-1}">
		<c:choose>
			<c:when
				test="${(!empty apptTimes[counter]) && agenda[index].equals(apptTimes[counter])}">
				<form method="GET" action="${formAction}">
					<tags:localTime time="${agenda[index]}" pattern="hh:mm a" />
					<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
					<button class="btn btn-3 btn-3e scheduled">
						<c:out value="Booked"></c:out>
					</button>
				</form>
				<c:set var="counter" value="${counter + 1}" />
			</c:when>
			<c:otherwise>
				<c:url var="formAction2" value="/patientScheduling">
				</c:url>
				<form method="GET" action="${formAction2}">
					<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
					<tags:localTime time="${agenda[index]}" pattern="hh:mm a" />
					<button class="btn btn-3 btn-3e open">open</button>
					<input type="hidden" name="time" value="${agenda[index]}" /> <input
						type="hidden" name="id" value="${index}" /> <input type="hidden"
						name="date" value="${date}" /> <input type="hidden"
						name="doctorId" value="${doctor.id}" />
				</form>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />

