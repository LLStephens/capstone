<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<title>Reviews</title>
<div class="loginBox">
	<div class="innerBox">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="reviewBox">
					<fieldset  >
						<legend id="legend">Reviews</legend>
						<c:url var="readReview" value="/readReviews" />
						<form class="forms" method="GET" action="${readReview}">
							<c:forEach var="review" items="${reviewList}">
								<c:out value="${review.rating}" /> - 
						<c:out value="${review.message}" /><br>
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