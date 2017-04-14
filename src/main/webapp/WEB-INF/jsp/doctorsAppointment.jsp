<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:import url="/WEB-INF/jsp/header.jsp" />
 

<div >

<div class = "container-fluid">
	<div class="container" id="doctorViewReview">
		<c:out value="${appointment.startDate} - " />
		<c:out value="${appointment.endDate}" />
		<div class="col-xs-6" >
			<c:out value="${appointment.patientId}" />
		</div>
		<div class="col-xs-6" id=>
			<c:out value="${appointment.message}" />
		</div>
	</div>
</div>


</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />