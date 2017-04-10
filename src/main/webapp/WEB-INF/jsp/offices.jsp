<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<c:import url="/WEB-INF/jsp/header.jsp" />

	<strong><span id="name"><c:out value="${office.name}" /></span></strong>
	<div class="doctors">
	<c:forEach var="doctor" items = "${doctorList}"><br>
		<c:out value="${doctor.name}"/><br>
		<img src="img/doctors/${doctor.name}" /><br>
		<c:out value="${review.rating}"/><br>
		<a href="WriteReview.jsp">Leave a Review</a><br>
	</c:forEach> 
	
	</div> 
<c:import url="/WEB-INF/jsp/footer.jsp" />