<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<div>

<c:forEach var="rating" items="${sortedDoctorRatingList}">
<c:out value="${rating}"/>
							<%-- <c:if test="${doctor.id == review.doctorId}">
								<c:set var="reviewCount" value="${reviewCount = reviewCount + 1}" />
								<c:set var="reviewTotal" value="${reviewTotal = reviewTotal + review.rating}" />
								<c:set var="reviewAvg" value="${reviewTotal/reviewCount}" />
							</c:if> --%>
							
</c:forEach><br/>
<c:forEach var="doctorId" items="${sortedDoctorIdsList}">
<c:out value="${doctorId}"/>
						
</c:forEach><br/>

<c:forEach var="doctor" items="${doctors}">
<c:out value="${doctor.id}"/>
						
</c:forEach>

</div> 

<c:import url="/WEB-INF/jsp/footer.jsp" />