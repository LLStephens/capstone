<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<div class="container-fluid alignmid">
	<img id="jumbo" src="img/abstract.jpg">
</div>
<div class="lrPadding">
	<div class="container-fluid alignmid" id="officeName">
		<div>	
			<c:set var="counter" value="0" />
			<c:forEach var="index" begin="0" end="5">
				<div class="col-sm-12 col-md-4 zeros">
					<div class="cotainer-fluid doctors">	
						<div>
								<c:forEach var="doctor" items="${doctorsList}">
									<c:if test = "${doctor.id == doctorIds[counter]}">
									<h4>
									<c:out value = "${doctor.name}"/></h4>
									<img class="container-fluid doctorImg" id = "doctorImg" src="img/doctors/${doctor.id}.jpg" />	<br/>								<c:set var = "reviewRating" value="${ratingsList[counter]}"/>
									
										
									
								<c:choose>
									<c:when test="${reviewRating == 0}">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
									</c:when>
									<c:when test="${reviewRating == 1}">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
									</c:when>
									<c:when test="${reviewRating == 2}">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
									</c:when>
									<c:when test="${reviewRating == 3}">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/empty_star.png">
										<img class = "star" src="img/stars/empty_star.png">
									</c:when>
									<c:when test="${reviewRating == 4}">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/empty_star.png">
									</c:when>
									<c:when test="${reviewRating == 5}">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
										<img class = "star" src="img/stars/full_star.png">
									</c:when>
									</c:choose>
										<h4>
										<c:forEach var="office" items="${officeList}">
											<c:if test = "${doctor.officeId == office.id}">
											<c:url var="offices" value = "/offices">
											<c:param name = "officeId" value = "${office.id}"/>
											</c:url>
												<a href  = "${offices}"><c:out value = "${office.name}"/></a>
												
											</c:if>
										</c:forEach>
										</h4>
										</c:if>	
									
									</c:forEach>
								</div>
							</div>
							
					</div>
					
					<c:set var="counter" value="${counter + 1}" />
				</c:forEach>
			</div>
		</div>			
</div>




<c:import url="/WEB-INF/jsp/footer.jsp" />
	

