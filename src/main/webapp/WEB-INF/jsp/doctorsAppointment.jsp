<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:import url="/WEB-INF/jsp/header.jsp" />
 

<div >

<div class = "container-fluid alignmid">
	<div class="container col-xs-12" id="doctorViewReview">
		<c:out value="${time}" /><br>
		<div class="col-xs-12 alignmid" >
			<c:out value="${patient.name} - ${patient.dateOfBirth}" />
		</div><br>
		<div class="col-xs-12" id=>
			<c:out value="${appointment.message}" />
		</div>
	</div>
</div>


</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />