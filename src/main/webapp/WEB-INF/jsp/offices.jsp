<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<!-- 		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
			rel="stylesheet"> -->

			<!-- <span class="stars" data-rating="2" data-num-stars="5"></span> -->
			<script>
			$.fn.stars = function() {
			    return $(this).each(function() {
			        var rating = $(this).data("rating");
			        var numStars = $(this).data("numStars");
			        var fullStar = new Array(Math.floor(rating + 1)).join('<i class="fa fa-star"></i>');
			        var halfStar = ((rating%1) !== 0) ? '<i class="fa fa-star-half-empty"></i>': '';
			        var noStar = new Array(Math.floor(numStars + 1 - rating)).join('<i class="fa fa-star-o"></i>');
			        $(this).html(fullStar + halfStar + noStar);
			    });
			} 
			
			 $('.stars').stars();
			 
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
					console.log(data);
					$("#allReviews").html("");
					for(var i = 0; i<data.length; i++){
						var message = data[i].message;
						var rating = data[i].rating;
						$("#allReviews").append(rating + " - " + message + "<br />");
					}	
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
							<p>Review avg is:<c:out value="${formatReviewAvg}" /><p>
							<div data-role="main" class="ui-content">
								<a href="#myReviewPopup" data-rel="popup" class="ui-btn ui-btn-inline ui-corner-all"
								onclick="readReviewForDoctor(${doctor.id})">Read reviews</a>
								<div data-role="popup" id="myReviewPopup" class="ui-content" style="min-width: 250px;">
									<p id="allReviews"></p>
									<a href="#" data-rel="back" class="ui-corner-all ui-shadow ui-btn">Close</a>
								</div>
							</div>
							<div data-role="main" class="ui-content">
								<a href="#myPopup${doctor.id}" data-rel="popup"
									class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left">Submit
									a review</a>
	
							<div data-role="popup" id="myPopup${doctor.id}" class="ui-content" style="min-width: 250px;">
								<a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow ui-btn ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
								<div data-doc="${doctor.id}">
									<h3>Write a review</h3>
									<label for="comment" class="ui-hidden-accessible">Comment:</label>
									<input id="review-${doctor.id}" type="text" name="message" id="comment" placeholder="Comment"> <a href="#"
									data-rel="back" id="submit" data-inline="true" onclick="reviewForDoctor(${doctor.id})">Submit</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>



<c:import url="/WEB-INF/jsp/footer.jsp" />

