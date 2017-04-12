<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
			rel="stylesheet"> 
<!-- 	<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script> -->

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="container-fluid alignmid">
	<img id="jumbo" src="img/abstract.jpg">
</div>
<div class="lrPadding">
	<div class="container-fluid alignmid">
		<h1>
			<c:out value="${officeName}" />
		</h1>
		<div>	
			
			<c:forEach var="doctor" items="${doctorList}">
				<div class="col-sm-12 col-md-4 zeros">
					<div class="cotainer-fluid doctors">
						<div>
							<h4>
								<c:out value="${doctor.name}" />
							</h4>
						</div>
						<div>
							<img class="container-fluid doctorImg" src="img/doctors/${doctor.id}.jpg" />
						</div>
						<c:set var="reviewCount" value="0" />
						<c:set var="reviewTotal" value="0" />
						<c:forEach var="review" items="${reviewList}">
							<c:if test="${doctor.id == review.doctorId}">
								<c:set var="reviewCount" value="${reviewCount = reviewCount + 1}" />
								<c:set var="reviewTotal" value="${reviewTotal = reviewTotal + review.rating}" />
								<c:set var="reviewAvg" value="${reviewTotal/reviewCount}" />
							</c:if>
							
						</c:forEach>
							<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${reviewAvg}" var="formatReviewAvg" />
							<p>Review avg is: <c:out value="${formatReviewAvg}" /><p>
							<c:url var ="reviewUrl" value="readReviews">
							<c:param name="doctorId" value="${doctor.id}"></c:param>
							</c:url>
							<a href="${reviewUrl}">Read Reviews</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>



<c:import url="/WEB-INF/jsp/footer.jsp" />

