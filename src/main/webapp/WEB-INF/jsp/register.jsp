<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<!-- <script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			
			rules : {
				name : {
					required: true,
					minlength:1,
				},
				userName : {
					required: true,
					minlength:1,
				},
				userName : {
					required: true,
					minlength:1,
				},
				userName : {
					required: true,
					minlength:1,
				},
				userName : {
					required: true,
					minlength:1,
				},
				userName : {
					required: true,
					minlength:1,
				},
				password : {
					required : true,
					maxlength:128,
					minlength:10,
					uppercase : true,
					lowercase : true,
					number : true,
					special: true,
					triples: true,
					
				},
				confirmPassword : {
					required : true,
					maxlength:128,
					minlength:10,
					uppercase : true,
					lowercase : true,
					number : true,
					special: true,
					triples: true,
					equalTo : "#password"  
				}
			},
			
			
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			
			errorClass: "error",
	        validClass: "valid", 
	        submitHandler: function(form) {
	            form.submit();
	        }
			
			
		});
	});
	
	$.validator.addMethod("uppercase", function (value, index) {
	    return value.match(/[A-Z]/);  
	}, "Please ensure your password contains one uppercase letter");
	
	$.validator.addMethod("lowercase", function (value, index) {
	    return value.match(/[a-z]/);  
	}, "Please ensure your password contains one lowercase letter");
	
	$.validator.addMethod("number", function (value, index) {
	    return value.match(/\d/);  
	}, "Please ensure your password contains one number");
	
	$.validator.addMethod("special", function (value, index) {
	    return value.match(/[&._-]/);  
	}, "Please ensure you have at least one special character");
	
	$.validator.addMethod("triples", function (value, index) {
	    return value.match(/(.)\1{2}/);  
	}, "you cannot repet the same letter number or symbol 3 times");
	
</script> -->


<div class="loginBox"
	style="background-image: url('img/whitey.jpg'); background-attachment: fixed">
	<div class="innerBox">
		<c:url var="formAction" value="/register" />
		<form method="POST" action="${formAction}">
		<%-- 	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> --%>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="form-group">
						<label for="name">Name: </label> <input type="text"
							id="name" name="name" placeHolder="Name"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="date_of_birth">Date of Birth: </label> <input type="text"
							id="date_of_birth" name="date_of_birth" placeHolder="Date of Birth"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="address">Address: </label> <input
							type="address" id="address" name="address"
							placeHolder="Re-Type Password" class="form-control" />
					</div>
					<div class="form-group">
						<label for="phone_number">Phone Number: </label> <input type="text"
							id="phone_number" name="phone_number" placeHolder="Phone Number"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="email">Email: </label> <input type="text"
							id="email" name="email" placeHolder="Email"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="user_name">User Name: </label> <input type="text"
							id="user_name" name="user_name" placeHolder="User Name"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="password">Password: </label> <input type="password"
							id="password" name="password" placeHolder="Password"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="corfirm_password">Confirm Password: </label> <input type="password"
							id="confirm_password" name="confirm_password" placeHolder="Please retype your password"
							class="form-control" />
					</div>
					<button type="submit" class="btn btn-default">Create User</button>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</form>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />