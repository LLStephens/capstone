<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">

$(document).ready(function () {
	 	$("form").validate({		
			 rules : {
				user_name : {
					required : true,
					minlength:1,
				},
				password : {
					required : true,
					minlength:10
								
				}
			},
			errorClass: "error",
			validClass: "valid", 
	        submitHandler: function(form) {
	            form.submit();
	        } 
		});
}); 

</script> 

<div class="loginBox">
	<div class="innerBox">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<legend class = "white" id="legend">Healthcare Provider Login</legend>
				<c:url var="formAction" value="/providerLogin" />
				<form method="POST" action="${formAction}">
					<div class="form-group white">
						<label for="user_name">User Name: </label> <input type="text"
							id="user_name" name="user_name" placeHolder="User Name"
							class="form-control" />
					</div>
					<div class="form-group white">
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