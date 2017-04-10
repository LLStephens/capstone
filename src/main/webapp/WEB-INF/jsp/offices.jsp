<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<div>
	<h2></h2>
</div>
<div class = "doctors">
<p>drs<p>
	<%-- <div>
		<c:url var="doctorPicture" value="img/doctors/${doctor.doctorName}.jpg"/>
		<img src = "${doctorPicture}" />
	</div>
	<p><strong><span id="name"><c:out value="${doctor.doctorName} - " /></span>
	<p id="doctorBio"><span id="bio" ><c:out value="${doctor.doctorBio}" /></span></p> --%>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />