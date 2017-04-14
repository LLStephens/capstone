<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:import url="/WEB-INF/jsp/header.jsp" />
 

<div >
	
	<div class = "col-xs-12" id = "doctorViewReview">
		<c:out value = "${appointment.startDate}"/>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<c:out value = "${appointment.endDate}"/>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<c:out value = "${appointment.id}"/>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<c:out value = "${appointment.message}"/>
	</div>
	
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />