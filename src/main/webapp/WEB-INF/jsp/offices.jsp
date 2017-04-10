<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Office</title>
</head>
<body>
	<strong><span id="name"><c:out value="${office.officeName}" /></span></strong>
	<div class="doctors">
	<c:forEach var="doctor" items = "${doctorList}">
		<img src="img/doctors/${doctor.doctorName}" />
		<c:out value="${review.rating}"/>
		<a href="WriteReview.jsp">Leave a Review</a>
	</c:forEach>
	
	</div>
</body>
</html>

