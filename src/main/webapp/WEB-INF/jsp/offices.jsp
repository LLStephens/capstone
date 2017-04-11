
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="container-fluid">

	</div>


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
		console.log("Posted Review");
		/* $("#myPopup").hide();  */
		/* $("#myPopup").dialog("open"); */
		// Hide here
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
</script>
	<c:forEach var="doctor" items="${doctorList}">
		<c:url var="detail" value="/readReviews">
			<c:param name="doctorId" value="${doctor.id}"></c:param>
		</c:url>

		<div class="col-sm-12 col-md-4 zeros">
			<div class="cotainer-fluid doctors">
				<div>
					<h4>
						<a href="${detail}"><c:out value="${doctor.name}" /></a>
					</h4>
				</div>

				<div >
					<img class = "container-fluid doctorImg" src="img/doctors/5.jpg" />
				</div>

				<div data-role="main" class="ui-content">
					<a href="#myPopup" data-rel="popup"
						class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left">Submit
						a review</a>

					<div data-role="popup" id="myPopup" class="ui-content"
						style="min-width: 250px;">
						<a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow ui-btn ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
						<div>
							<h3>Write a review</h3>
							<label for="comment" class="ui-hidden-accessible">Comment:</label>
							<input id="review-${doctor.id}" type="text" name="message" id="comment" placeholder="Comment">
							<a href="#" data-rel="back" id="submit" data-inline="true" onclick="reviewForDoctor(${doctor.id})">Submit</a>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
</div>



<c:import url="/WEB-INF/jsp/footer.jsp" />

