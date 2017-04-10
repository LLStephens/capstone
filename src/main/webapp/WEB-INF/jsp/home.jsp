<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

	<div class="container-fluid">
		<div class = "pageTitle">	
		<p> Neutralspace Personal Healthcare Network</p>
		</div>
	<c:url value="/offices" var="offices" />
	<a href="${offices}" >click me</a>
	</div>
	
	
	

<c:import url="/WEB-INF/jsp/footer.jsp" />