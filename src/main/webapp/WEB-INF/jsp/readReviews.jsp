<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<title>Reviews</title>
<div class="loginBox">
	<div class="innerBox">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="reviewBox">
					<fieldset>
						<legend id="legend">Reviews</legend>
						<c:url var="readReview" value="/readReviews" />
						<form class="forms" method="GET" action="${readReview}">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
							<c:forEach var="review" items="${reviewList}">
							<div class="col-sm-12 col-md-12 zeros">
							<div class="countainer-fluid reviewLines">
							<c:set var="reviewRating" value="${review.rating+((review.rating%1>0.5)?(1-(review.rating%1))%1:-(review.rating%1))}"/>
								<div class="container-fluid">
								
							<c:choose>
								<c:when test="${reviewRating == 0}">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
								</c:when>
								<c:when test="${reviewRating == 1}">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
								</c:when>
								<c:when test="${reviewRating == 2}">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
								</c:when>
								<c:when test="${reviewRating == 3}">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/empty_star.png">
									<img class = "star" src="img/stars/empty_star.png">
								</c:when>
								<c:when test="${reviewRating == 4}">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/empty_star.png">
								</c:when>
								<c:when test="${reviewRating == 5}">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
									<img class = "star" src="img/stars/full_star.png">
								</c:when>
								</c:choose>
							
								</div>
						<c:out value="${review.message}" /><br>
						<c:if test="${not empty review.response}">
							Reply from the doctor: <c:out value="${review.response}" /><br>
						</c:if>
						<c:if test="${not empty review.patientId}">
							Verified reviewer: <c:out value="${review.patientId}" /><br>
						</c:if>
							</div>
							</div>
							</c:forEach>
							
						</form>
					</fieldset>
				</div>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />