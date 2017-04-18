<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class = "alignmid">

	<div class = "container-fluid alignmid">
		<div class="container col-xs-12" id="doctorViewReview">
			<h3>This appointment is currently open</h3>
			<c:out value="${appointment[id]}" />
			<c:out value="${date}" />
		</div>
		<div class = "alignmid">
		
			<c:url var="submitAppointment" value="/submitAppointment">
				<c:param name="id" value="${map.get(apptTimes[counter]).id}"></c:param>
			</c:url>
						
			<form method="POST" action="${submitAppointment}">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
				<div class="container-fluid stars">
 				<textarea class="textBox" rows="4" cols="50" name="message" id= "message" ></textarea>
				</div>
				<button class="open" style="width: 20%; height: 100%">
					<c:out value="Book this appointment" />
				</button>
				<input type="hidden" name="date" value="${date}" />
				<input type ="hidden" name = "time" value = "${time}"/>
			</form>
		</div>
	</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />