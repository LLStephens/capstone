
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="container-fluid">

	</div>


<div class="container-fluid">
<h1>
	<c:out value="${officeName}" />
</h1>
<div>

	<c:forEach var="doctor" items="${doctorList}">
		<c:url var="detail" value="/readReviews">
			<c:param name="doctorId" value="${doctor.id}"></c:param>
		</c:url>

		<div class="col-sm-12 col-md-4 zeros">
			<div class="doctors">
				<div>
					<h4>
						<a href="${detail}"><c:out value="${doctor.name}" /></a>
					</h4>
				</div>

				<div>
					<img src="img/doctors/5.jpg" />
				</div>

				<div>
					<c:out value="${rating}" />
				</div>

				<div data-role="main" class="ui-content">
					<a href="#myPopup" data-rel="popup"
						class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left">Submit
						a review</a>

					<div data-role="popup" id="myPopup" class="ui-content"
						style="min-width: 250px;">

						<form method="post" action="/action_page_post.php">
							<div>
								<h3>Write a review</h3>
								<label for="comment" class="ui-hidden-accessible">Comment:</label>
								<input type="text" name="comment" id="comment"
									placeholder="Comment"> <input type="submit"
									data-inline="true" value="Submit">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
</div>



<c:import url="/WEB-INF/jsp/footer.jsp" />

