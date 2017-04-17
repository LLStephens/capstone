<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<title>Reviews</title>
<div class="loginBox">
	<div class="innerBox">
		<div class="row">
			<div class="col-sm-2">
			<c:url var="login" value="/login" />
			<c:if test="${patientId <1}">
			<a href = "${login}">Please login or register to leave a verified review</a>
			</c:if>
			<c:if test="${patientId >0}">
			<p>This is a verifed review</p>
			</c:if>
			</div>
			<div class="col-sm-8">
				<div class="reviewBox">
					<legend id="legend">Leave a Review</legend>
					
					<form class="forms" method="POST" action="${writeReview}">
						Comment:<br>
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
						<div class="container-fluid stars">
 							<textarea class="textBox" rows="4" cols="50" name="message"></textarea>
						</div>
						
						<legend id="legend">Please rate:</legend>
						<input type="radio" id="starRating" name="rating" value="5" />  Excellent   
						<input type="radio" id="starRating" name="rating" value="4" />  Great   
						<input type="radio" id="starRating" name="rating" value="3" />  Good   
						<input type="radio" id="starRating" name="rating" value="2" />  Fair   
						<input type="radio" id="starRating" name="rating" value="1" />  Poor <br><br>	
						<input id = "submit" type="submit">  
 						<input type="hidden" name="doctorId" value="${doctorId}">
 						<c:if test="${patientId > 0}">
   						<input type="hidden" name="patientId" value="${patientId}">
   						</c:if>
  					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-4"></div>
	</div>
</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />