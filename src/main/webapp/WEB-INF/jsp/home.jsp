<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


	<div class="container-fluid">
	<div>
	
	<h1> Neutralspace Personal Healthcare Network</h1>
	</div>
	</div>
	
	<c:forEach var="office" items = "${officeList}">
		<c:out value="${office.name}"/>
	</c:forEach>
	

<c:import url="/WEB-INF/jsp/footer.jsp" />