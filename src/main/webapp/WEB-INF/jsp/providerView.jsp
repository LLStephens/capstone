<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:import url="/WEB-INF/jsp/header.jsp" />
 
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
 <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );

  function getDate() {
      document.getElementById("datepicker").val();
  }
  </script>

  
<p>Date: <input type="text" id="datepicker"></p>
<label id="hoursLabel">Hourly Rate</label> <input id="hourstTxt" type="text"><br>
<label id="hoursLabel">placeholder</label> <input id="hourstTxt" type="text">

<%-- <c:url var ="providerViewrUrl" value="get()">
	<c:param name="date" value="${providerViewUrl}"></c:param>
</c:url> --%>

<c:forEach var="appt" items="${apptTimes}">
	<c:out value="${appt}" />
</c:forEach> 



<div >

	<div class = "container alignmid pageTitle" style = "color: green">
		<c:out value="Hello ${doctor.name}"/>
	</div>
	
	<div class = "container col-xs-12 col-sm-3 zeros alignmid" >
		<div class = "col-xs-12 " id ="doctorSideBar">
			<img style = "width:150px"class="doctorImg" src="img/doctors/${doctor.id}.jpg" />
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
				<p>8:00 - 8:30 Name - message</p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>8:30 - 9:00 Name - message</p>
			</div>
			<div class = "col-xs-12 open" id = "doctorViewReview">
				<p>9:00 - 9:30 - OPEN</p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>9:30 - 10:00  Name - message</p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>10:00 - 10:30 Name - message </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>10-:30 - 11:00 Name - message </p>
			</div>
			<div class = "col-xs-12 open" id = "doctorViewReview">
				<p>11:00 - 11:30 - OPEN </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>11:30 - 12:00  Name - message </p>
			</div>
			<div class = "col-xs-12 unavailable" id = "doctorViewReview">
				<p>LUNCH</p>
			</div>
			<div class = "col-xs-12 unavailable" id = "doctorViewReview">
				<p>LUNCH</p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>1:00 - 1:30 Name - message </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>1:30 - 2:00  Name - message</p>
			</div>
			<div class = "col-xs-12 open" id = "doctorViewReview">
				<p>2:00 - 2:30 - OPEN  </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>2:30 - 3:00 Name - message </p>
			</div>
			<div class = "col-xs-12 scheduled" id = "doctorViewReview">
				<p>3:00 - 3:30 Name - message </p>
			</div>
		</div>
	</div>
	
	<div class = "col-xs-12 alignmid pageTitle">
		<div>
			<c:out  value="Your reviews:"/>
		</div>
		
		<div>
		 	<c:forEach var="review" items="${review}">
<!-- 		 		<div class = "col-xs-12 col-sm-4 reviewColor" id = "doctorViewReview"> -->
					<c:out value="${review.message}"/><br>
					<c:out value="${review.rating}"/><br>			
<!-- 				</div>			
 -->			</c:forEach>
		</div>
		
	</div>
	

</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />