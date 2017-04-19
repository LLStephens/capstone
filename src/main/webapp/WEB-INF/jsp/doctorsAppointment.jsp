<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<div class="container">
	<div class="loginBox">
		<div class="innerBox">
			<div class="row">
				<div class="container col-xs-12">
					<legend id="legend">Appointment Details</legend>

					<div class="container col-xs-12">
						<div class="apptText">
							Appointment time: <c:out value="${time}" /><br>
							Patient name: <c:out value="${patient.name}"/><br>
							Date of birth: <c:out value="${patient.dateOfBirth}" /><br>
							Message (if applicable): <c:out value="${appointment.message}" /><br>
						</div>
						<br>
						<div class="alignmid">
							<c:url var="doctorsAppt" value="/doctorsAppointment"></c:url>
							<form method="POST" action="${doctorsAppt}">
								<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
								<%-- 			<input type ="hidden" name = "doctorId" value = "${doctorId}"/> --%>
								<input type="hidden" name="appointmentId"
									value="${appointment.id}" />
								<button id="login_button" type="submit" class="btn btn-default">
									<c:out value="Cancel appointment" />
								</button>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />