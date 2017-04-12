<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="loginBox">
	<div class="innerBox">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<c:url var="formAction" value="/login" />
				<form method="POST" action="${formAction}">
					<div class="form-group">
						<label for="userName">User Name: </label> <input type="text"
							id="user_name" name="user_name" placeHolder="User Name"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="password">Password: </label> <input type="password"
							id="password" name="password" placeHolder="Password"
							class="form-control" />
					</div>
					<input type="hidden" value="${param.destination}"
						name="destination" />
					<button type="submit" class="btn btn-default">Login</button>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />