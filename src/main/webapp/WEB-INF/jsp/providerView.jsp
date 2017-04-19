<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker();
		/*  $("#datepicker").datepicker({minDate: 0, maxDate: "+6m", beforeShowDay: $.datepicker.noWeekends}); */
	});

</script>

<div class="container col-xs-12 col-sm-4 zeros sidebar ">
	<div class="col-xs-12 alignmid viewDivs" id="doctorSideBar">
		<img style="width: 150px; margin: 25px 0px 0px 0px" class="doctorImg"
			src="img/doctors/${doctor.id}.jpg" />
		<h4>
			<c:out value="Hello ${doctor.name}" />
		</h4>
		<c:url var="changePasswordUrl" value="changePassword">
			<c:param name="doctorId" value="${doctor.id}"></c:param>
		</c:url>
		<a id="changePassword" href="${changePasswordUrl}">Change Password</a>
		<br>
		<form id="feeForm" class="forms" method="POST"
			action="${providerView}">
			<br> <input type="hidden" name="CSRF_TOKEN"
				value="${CSRF_TOKEN}" /> Set hourly rate: <input id="feeLabel"
				type="text" name="fee"> <input type="hidden" name="doctorId"
				value="${doctor.id}"> <input id = "btnTop" type="submit" value="Submit" style = "margin: 10px 0px 0px 0px">
		</form>
		<br>
		<div class = "container-fluid viewReviewDivs ">
			<h4>Reviews</h4>
			<c:forEach var="review" items="${review}">
				<c:out value="${review.rating}" /> - <c:out
					value="${review.message}" />
				<c:url var="updateReviewUrl" value="updateReview">
					<c:param name="doctorId" value="${doctor.id}"></c:param>
					<c:param name="reviewId" value="${review.id}"></c:param>
				</c:url> <br/>
				<a  class  = "topbotmargins" href="${updateReviewUrl}">Respond</a>
				<br>
			</c:forEach>
		</div>
		<br>

	</div>
</div>
<div class="col-xs-12 col-sm-8 alignmid ">
	<div class="col-xs-12 ">
		<c:url var="providerView" value="/providerView" />
		<form method="GET" action="${providerView}">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			Select Date: <input name="date" id="datepicker" /> <input
				type="hidden" name="doctorId" value="${doctor.id}"> <input id="btnTop2"
				type="submit" value="Submit">
		</form>
		<h4>
			Your agenda for:
			<tags:localDate date="${date}" pattern="MM/dd/yyyy" />
		</h4>
		<c:url var="appointment" value="/doctorsAppointment" />
		<c:set var="counter" value="0" />
		<c:forEach var="index" begin="0" end="${fn:length(agenda)-1}">
			<c:choose>
				<c:when
					test="${(!empty apptTimes[counter]) && agenda[index].equals(apptTimes[counter])}">
					<c:url var="formAction" value="/doctorsAppointment">
						<c:param name="id" value="${map.get(apptTimes[counter]).id}"></c:param>
					</c:url>
					<!-- class unavailable is here -->
					<form method="GET" action="${formAction}">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
						<tags:localTime time="${apptTimes[counter]}" pattern="hh:mm a" />
						<button class="btn btn-3 btn-3e scheduled" >scheduled</button>
						<input type="hidden" name="id"
							value="${map.get(apptTimes[counter]).id}" />
					</form>
					<c:set var="counter" value="${counter + 1}" />
				</c:when>
				<c:otherwise>
					<c:url var="formAction2" value="/doctorScheduling">
						<c:param name="id" value="${map.get(apptTimes[counter]).id}"></c:param>
					</c:url>
					<form method="GET" action="${formAction2}">
						<tags:localTime time="${agenda[index]}" pattern="hh:mm a" />
						<button class="btn btn-3 btn-3e open">open</button>
						<input type="hidden" name="time" value="${agenda[index]}" /> 
						<input type="hidden" name="id" value="${index}" /> 
						<input type="hidden" name="date" value="${date}" />
					</form>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />