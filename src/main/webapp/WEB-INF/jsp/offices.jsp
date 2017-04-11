<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="container-fluid"></div>


<div class="container-fluid alignmid">
	<h1>
		<c:out value="${officeName}" />
	</h1>
	<div>
		<script>
function postReview(review) {
	$.ajax({
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		url:'/capstone/api/review',
		type: 'POST',
        dataType: 'json',
        data: JSON.stringify(review)
	})
	.done(function(data) {
	})
	.fail(function(xhr, status, error){
		console.log(error);
		// Show some kind of error
	});
}

function reviewForDoctor(id) {
	var comment = $('#review-'+id).val();
	// Get rating
	postReview({doctorId:id, message:comment});
}

function readReviews(doctorId) {
	$.ajax({
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		url:'/capstone/api/review?doctorId='+doctorId,
		type: 'GET',
        dataType: 'json'
	})
	.done(function(data) {
		var message = data[0].message;
		var rating = data[0].rating;
		$("#allReviews").html(rating + " - " + message);
	})
	.fail(function(xhr, status, error){
		console.log(error);
	});
}

function readReviewForDoctor(id) {
	readReviews(id);
	
}
</script>
		<c:forEach var="doctor" items="${doctorList}">
			<div class="col-sm-12 col-md-4 zeros">
				<div class="cotainer-fluid doctors">
					<div>
						<h4>
							<a href="${detail}"><c:out value="${doctor.name}" /></a>
						</h4>
					</div>

					<div>
						<img class="container-fluid doctorImg" src="img/doctors/5.jpg" />
					</div>
					
					<c:set var="reviewCount" value="0" />
					<c:set var="reviewTotal" value="0" />
					<c:forEach var="review" items="${reviewList}">
						<c:if test="${doctor.id == review.doctorId}">
							<c:set var="reviewCount" value="${count = count + 1}" />
							<c:set var="reviewTotal" value="${reviewTotal + review.rating}" />
							<c:set var="reviewAvg" value="${reviewTotal/reviewCount}" />
						</c:if>
					</c:forEach>

					<fmt:formatNumber type="number" maxFractionDigits="2"
						value="${reviewAvg}" var="formatReviewAvg" />
					<p>Review is: <c:out value="${formatReviewAvg}" /><p>
					
					<div data-role="main" class="ui-content">
						<a href="#myReviewPopup" data-rel="popup"
							class="ui-btn ui-btn-inline ui-corner-all"
							onclick="readReviewForDoctor(${doctor.id})">Read reviews</a>

						<div data-role="popup" id="myReviewPopup" class="ui-content"
							style="min-width: 250px;">
							<p id="allReviews">Reviews</p>
							<a href="#" data-rel="back"
								class="ui-corner-all ui-shadow ui-btn">Close</a>
						</div>
					</div>

					<div data-role="main" class="ui-content">
						<a href="#myPopup" data-rel="popup"
							class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left">Submit
							a review</a>

						<div data-role="popup" id="myPopup" class="ui-content"
							style="min-width: 250px;">
							<a href="#" data-rel="back"
								class="ui-btn ui-corner-all ui-shadow ui-btn ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
							<div>
								<h3>Write a review</h3>
								<label for="comment" class="ui-hidden-accessible">Comment:</label>
								<input id="review-${doctor.id}" type="text" name="message"
									id="comment" placeholder="Comment"> <a href="#"
									data-rel="back" id="submit" data-inline="true"
									onclick="reviewForDoctor(${doctor.id})">Submit</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>



<c:import url="/WEB-INF/jsp/footer.jsp" />

