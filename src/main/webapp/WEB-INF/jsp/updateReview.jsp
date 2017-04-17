<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<title>Reviews</title>
<div class="loginBox">
	<div class="innerBox">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="reviewBox">
					<legend id="legend">Review</legend>
					<form class="forms" method="POST" action="${updateReview}">
						Comment:<br>
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
						<div class="container-fluid stars">
 							<textarea class="textBox" rows="4" cols="50" name="response"></textarea>
 							<input type="hidden" name="doctorId" value="${doctorId}">
 							<input type="submit" value="Submit">
						</div>
 					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-4"></div>
	</div>
</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />