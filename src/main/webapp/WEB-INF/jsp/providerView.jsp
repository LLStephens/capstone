<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:import url="/WEB-INF/jsp/header.jsp" />
 

<div >

	<div class = "container alignmid pageTitle" style = "color: green">
		<c:out value="Hello ${doctor.name}"/>
	</div>
	
	<div class = "container col-xs-12 col-sm-3 zeros alignmid" >
		<div class = "col-xs-12 " id ="doctorSideBar">
			<img style = "width:150px"class="doctorImg" src="img/doctors/${doctor.id}.jpg" />
		</div>
		<div class="col-xs-12 zeros " id="doctorSideBar">
			<div>
				<label id="hoursLabel">Starting hours</label> <input id="hourstTxt"
					type="text">
			</div>
			<div>
				<label id="hoursLabel">Ending hours</label> <input id="hourstTxt"
					type="text">
			</div>
			<div>
				<label id="hoursLabel">fee</label> <input id="hourstTxt" type="text">
			</div>
			<div>
				<label id="hoursLabel">blahhh</label> <input id="hourstTxt"
					type="text">
			</div>
			<div>
				<label id="hoursLabel">sdafasdfa sdfad sfasfas dfdas
					asdfasdfd safasdfa sdfadsfasdfasdfa sdfasdf asdfsadgdfsg asdg sgas
					ga gfdga fgdfs sh fghdfghadfh dfsg s fdsfhsdf hdfsh fsdh s </label>
			</div>
			<div>
				<button>doctor update button</button>
			</div>
		</div>

	</div>
	
	
	<div class = "ol-xs-12 col-sm-9 alignmid pageTitle">
		<div>
		<c:out value="today's schedule"/>
		</div>
		<!-- enter Schedule items here in a list, click to view appointment data -->
		<div class = "col-xs-12 ">
			<c:url var="appointment" value= "/doctorsAppointment"/>
			<a href = "${appointment}">Clickable divs here </a>
			
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>8:00 - 8:30    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>8:30 - 9:00    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 open" id = "doctorViewReview">
				<p>9:00 - 9:30 - OPEN</p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>9:30 - 10:00    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>10:00 - 10:30    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>10-:30 - 11:00    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 open" id = "doctorViewReview">
				<p>11:00 - 11:30 - OPEN </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>11:30 - 12:00    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 unavailable" id = "doctorViewReview">
				<p>LUNCH</p>
			</div>
			<div class = "col-xs-12 unavailable" id = "doctorViewReview">
				<p>LUNCH</p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>1:00 - 1:30    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>1:30 - 2:00    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 open" id = "doctorViewReview">
				<p>2:00 - 2:30 - OPEN  </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>2:30 - 3:00    Jane doe    blah blah blah </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>3:00 - 3:30    Jane doe    blah blah blah </p>
			</div>
		</div>
	</div>
	
	<div class = "col-xs-12 alignmid pageTitle">
		<div>
			<c:out  value="Your reviews:"/>
		</div>
		
		<div>
		 	<c:forEach var="review" items="${review}">
		 		<div class = "col-xs-12 col-sm-4 reviewColor" id = "doctorViewReview">
					<c:out value="${review.message}"/><br>
					<c:out value="${review.rating}"/>			
				</div>			
			</c:forEach>
		</div>
		
	</div>
	

</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />