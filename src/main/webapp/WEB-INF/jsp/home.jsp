<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

	<div class="container-fluid">

	</div>
	
	 <div class="container-fluid">
		<c:forEach var="office" items="${officeList}">
	
			<c:url var="detail" value="/offices">
				<c:param name="officeId" value="${office.id}"></c:param>
			</c:url>
		<div class = "col-sm-12 col-md-6 zeros " >
			<div class = "offices">
			<div>
				<c:url var="officePicture" value="img/office/${office.imageName}.jpg" />
				<a href="${detail}" > <img class = "officePic" src="${officePicture}" /></a>
			</div>
			
			<div>
				<h4>
					<a href="${detail}"><c:out value="${office.name}" /> </a>
				</h4>
				<p>
					<c:out value="${office.address}" />
				</p>
			</div>
			</div>
		</div>
	
		</c:forEach>
	</div> 
	
<c:import url="/WEB-INF/jsp/footer.jsp" />