<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

	<div class="container-fluid">

		<div class = "pageTitle">	
		<p> Neutralspace Personal Healthcare Network</p>
		</div>
	<c:url value="/offices" var="offices" />
	<a href="${offices}" >click me</a>

	</div>
	
	<div class="container-fluid">
		<c:forEach var="office" items="${officeList}">
	
			<c:url var="detail" value="/offices">
				<c:param name="officeId" value="${office.id}"></c:param>
			</c:url>
	
			<div>
				<c:url var="officePicture" value="img/office/${office.imageName}.jpg" />
				<a href="${detail}" > <img src="${officePicture}" /></a>
			</div>
			
			<div>
				<h4>
					<a href="${detail}"><c:out value="${office.name}" /> </a>
				</h4>
				<p>
					<c:out value="${office.address}" />
				</p>
			</div>
	
		</c:forEach>
	</div>
	
	
	
	
<c:import url="/WEB-INF/jsp/footer.jsp" />