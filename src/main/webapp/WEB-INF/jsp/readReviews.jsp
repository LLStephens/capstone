<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" href="fontawesome-stars.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="jquery.barrating.min.js"></script>
<script type="text/javascript">
   $(function() {
      $('#example').barrating({
        theme: 'fontawesome-stars'
      });
   });
</script>



<select id="example">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select>

<c:import url="/WEB-INF/jsp/header.jsp" />
<title>Reviews</title>
<div class="container">
<div class="loginBox">
	<div class="innerBox">
	<div class="row">
		<div class="reviewBox">
		<legend id="legends">Reviews</legend> 
			<table class="table table-responsive">
				<tbody>
					<c:url var="readReview" value="/readReviews" />
					<form class="forms" method="GET" action="${readReview}">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
						<c:forEach var="review" items="${reviewList}">
							<tr>
								<td><c:set var="reviewRating"
										value="${review.rating+((review.rating%1>0.5)?(1-(review.rating%1))%1:-(review.rating%1))}" />

									<c:choose>
										<c:when test="${reviewRating == 0}">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
										</c:when>
										<c:when test="${reviewRating == 1}">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
										</c:when>
										<c:when test="${reviewRating == 2}">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
										</c:when>
										<c:when test="${reviewRating == 3}">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/empty_star.png">
											<img class="star" src="img/stars/empty_star.png">
										</c:when>
										<c:when test="${reviewRating == 4}">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/empty_star.png">
										</c:when>
										<c:when test="${reviewRating == 5}">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
											<img class="star" src="img/stars/full_star.png">
										</c:when>
									</c:choose> - <c:out value="${review.message}" /> <br> <c:if
										test="${not empty review.response}">
										<span class="reply">Reply from the doctor: </span>
										<c:out value="${review.response}" />
										<br>
									</c:if> <c:if test="${review.patientId > 0}">
										<c:out value="This is a verified review" />
										<br>
									</c:if></td>
							</tr>
						</c:forEach>
					</form>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />