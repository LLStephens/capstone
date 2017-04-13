<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:import url="/WEB-INF/jsp/header.jsp" />
 

<div >

	<div class = "container alignmid pageTitle border">
		<c:out value="Hello ${doctor.name}"/>
	</div>
	
	<div class = "container col-xs-12 col-sm-3 zeros alignmid border" >
		<div class = "col-xs-12 " id ="doctorSideBar">
			<img style = "width:150px"class="doctorImg" src="img/doctors/${doctor.id}.jpg" />
		</div>
		<div class = "col-xs-12 col-sm-6 zeros " id ="doctorSideBar">
			<label id = "hoursLabel">Starting hours</label>
			<input id = "hourstTxt" type = "text">
			<label id = "hoursLabel">Ending hours</label>
			<input id = "hourstTxt" type = "text">
			<label id = "hoursLabel">fee</label>
			<input id = "hourstTxt" type = "text">
			<label id = "hoursLabel">blahhh</label>
			<input id = "hourstTxt" type = "text">
			<label id = "hoursLabel">sdafasdfa sdfad sfasfas dfdas
			asdfasdfd safasdfa sdfadsfasdfasdfa sdfasdf asdfsadgdfsg
			asdg sgas ga gfdga fgdfs sh fghdfghadfh dfsg s
			 fdsfhsdf hdfsh fsdh s </label>
		</div>
		
	</div>
	
	
	<div class = "ol-xs-12 col-sm-9 border alignmid pageTitle">
		<div>
		<c:out value="today's schedule"/>
		</div>
		<!-- enter Schedule items here in a list, click to view appointment data -->
		<div class = "col-xs-12 " id = "doctorViewReview">
			<c:url var="appointment" value= "/doctorsAppointment"/>
			<a href = "${appointment}">Clickable divs here </a>
			
			<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
	<div class = "col-xs-12" id = "doctorViewReview">
		<p>9:00 - 9:30    Jane doe    blah blah blah </p>
	</div>
		</div>
	</div>
	
	<div class = "col-xs-12  border alignmid pageTitle">
		<div>
			<c:out  value="Your reviews:"/>
		</div>
		
		<div>
		 	<c:forEach var="review" items="${review}">
		 		<div class = "col-xs-12 col-sm-4" id = "doctorViewReview">
					<c:out value="${review.message}"/>
					<c:out value="${review.rating}"/>			
				</div>			
			</c:forEach>
		</div>
		
	</div>
	

</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />