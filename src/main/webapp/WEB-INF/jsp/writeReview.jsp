<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<title>Reviews</title>
<div class="loginBox">
	<div class="innerBox">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="reviewBox">
					<form>
						<fieldset>
							<legend>Review</legend>
							Comments:<br>
							<c:url var="writeReview" value="/" />
							<form method="POST" action="${writeReview}">
								<div class="container-fluid"><input type="text" class="textBox"><br> </div>
        						<button>Send</button>
        					</form>
							Star ratings visualized here
						</fieldset>
					</form>
					</div>
				</div>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />