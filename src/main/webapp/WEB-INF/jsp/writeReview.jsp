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
					<form class="forms" method="POST" action="${writeReview}">
						Comment:<br>
						<div class="container-fluid">
 							<textarea class="textBox" rows="4" cols="50" name="comment"></textarea>
							
						</div>
<!-- 					</form>
					<form class="forms"> -->
						<legend id="legend">Please rate:</legend>
						<input type="radio" id="star5" name="rating" value="5" />  Excellent   
						<input type="radio" id="star4" name="rating" value="4" />  Great   
						<input type="radio" id="star3" name="rating" value="3" />  Good   
						<input type="radio" id="star2" name="rating" value="2" />  Fair   
						<input type="radio" id="star1" name="rating" value="1" />  Poor <br><br>	
						<input id = "submit" type="submit">  
					</form>
					
				</div>
			</div>
		</div>
		<div class="col-sm-4"></div>
	</div>
</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />