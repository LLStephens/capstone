<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<script>

</script>
<title>Reviews</title>
<div class="loginBox">
	<div class="innerBox">
		<div class="row">
			<div class="col-sm-2">
				<c:if test="${patientId >0}">
					<p>This is a verifed review</p>
				</c:if>
			</div>
			<div class="col-sm-8">
				<div class="reviewBox">
					<legend id="legend">Leave a Review</legend>
					<c:url var="login" value="/login" />
					<c:if test="${patientId <1}">
						<a href="${login}">Please login or register to leave a
							verified review</a><br><br>
					</c:if>
					<form class="forms" method="POST" action="${writeReview}">
						<input type="hidden" name="CSRF_TOKEN"
							value="${CSRF_TOKEN}" />
						
					<span class="rating"> 
						<input type="radio" class="rating-input" id="star" value="5" name="rating">
						<label for="rating-input-1-5" class="rating-star"></label> 
						<input type="radio" class="rating-input" id="star" value="4" name="rating"> 
						<label for="rating-input-1-4" class="rating-star"></label> 
						<input type="radio" class="rating-input" id="star" value="3" name="rating">
						<label for="rating-input-1-3" class="rating-star"></label> 
						<input type="radio" class="rating-input" id="star" value="2" name="rating"> 
						<label for="rating-input-1-2" class="rating-star"></label> 
						<input type="radio" class="rating-input" id="star" value="1" name="rating">
						<label for="rating-input-1-1" class="rating-star"></label>
					</span>
					<div class="container-fluid stars">
							<br>Comment:<br> <textarea class="textBox" rows="4" cols="50" name="message"></textarea>
						</div>	
					<button id="login_button" type="submit" class="btn btn-default">Submit</button>
						<input type="hidden" name="doctorId" value="${doctorId}">
						<c:if test="${patientId > 0}">
							<input type="hidden" name="patientId" value="${patientId}">
						</c:if>
					</form>
						<!-- 
						<input type="radio" id="starRating" name="rating" value="5" />
						Excellent <input type="radio" id="starRating" name="rating"
							value="4" /> Great <input type="radio" id="starRating"
							name="rating" value="3" /> Good <input type="radio"
							id="starRating" name="rating" value="2" /> Fair <input
							type="radio" id="starRating" name="rating" value="1" /> Poor <br>
						<br> -->
				</div>
			</div>
		</div>
		<div class="col-sm-4"></div>
	</div>
</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />