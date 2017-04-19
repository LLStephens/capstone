<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">

$(document).ready(function () {
	 	$("form").validate({		
			 rules : {
				name : {
				required: true,
					minlength:1,
				},
				date_of_birth : {
					required: true,
					minlength:1,
					birthday:true,
				},
				address : {
					required: true,
					minlength:1,
				},
				phone_number : {
					required: true,
					minlength:1,
					phone:true,
				},
				email : {
					required: true,
					minlength:1,
					email:true,
					
				},
				user_name : {
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
				},
				confirm_password : {
					required : true,
					maxlength:128,
					minlength:10,
					uppercase : true,
					lowercase : true,
					number : true,
					equalTo : "#password"  
				}
			},
			messages : {			
				confirm_password : {
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
	
	$.validator.addMethod("birthday", function (value, index) {
	    return value.match(/(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d/);  
	}, "Please enter a proper birthday");
	
	$.validator.addMethod("email", function (value, index) {
	    return value.match(/^[a-z][a-zA-Z0-9_.]*(\.[a-zA-Z][a-zA-Z0-9_.]*)?@[a-z][a-zA-Z-0-9]*\.[a-z]+(\.[a-z]+)?$/);  
	}, "Please enter a valid email address");
	
	$.validator.addMethod("phone", function (value, index) {
	    return value.match(/^(?:(?:\+?1\s*(?:[.-]\s*)?)?(?:\(\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\s*\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\s*(?:[.-]\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\s*(?:[.-]\s*)?([0-9]{4})(?:\s*(?:#|x\.?|ext\.?|extension)\s*(\d+))?$/);  
	}, "Please enter a valid phone number");
	 
</script>


<div class="loginBox">
	<div class="innerBox">
		<legend class = "white" id="legend">New Patient Registration</legend>
		<c:url var="formAction" value="/register" />
		<form id = "theorm" method="POST" action="${formAction}">
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />			
		<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-12">
					<div class = "container-fluid">
						<div class="form-group white col-md-4 col-sm-12 ">
							<label for="name">Name: </label> <input type="text"
								id="name" name="name" placeHolder="Name"
								class="form-control" />
						</div>
						<div class="form-group white col-md-4 col-sm-12">
							<label for="date_of_birth">Date of Birth:</label> <input type="text"
								id="date_of_birth" name="date_of_birth" placeHolder="mm/dd/yyyy"
								class="form-control" />
						</div>
						<div class="form-group white col-md-4 col-sm-12">
							<label for="address">Address: </label> <input
								type="address" id="address" name="address"
								placeHolder="address" class="form-control" />
						</div>
					</div>
					<div class = "container-fluid">
						<div class="form-group white col-md-4 col-sm-12">
							<label for="phone_number">Phone Number: </label> <input type="text"
								id="phone_number" name="phone_number" placeHolder="Phone Number"
								class="form-control" />
						</div>
						<div class="form-group white col-md-4 col-sm-12">
							<label for="email">Email: </label> <input type="text"
								id="email" name="email" placeHolder="Email"
								class="form-control" />
						</div>
						<div class="form-group white col-md-4 col-sm-12">
							<label for="user_name">User Name: </label> <input type="text"
								id="user_name" name="user_name" placeHolder="User Name"
								class="form-control" />
						</div>
					</div>
					<div class = "container-fluid">
						<div class="form-group white col-md-6 col-sm-12">
							<label for="password">Password: </label> <input type="password"
								id="password" name="password" placeHolder="Password"
								class="form-control" />
						</div>
						<div class="form-group white col-md-6 col-sm-12">
							<label for="corfirm_password">Confirm Password: </label> <input type="password"
								id="confirm_password" name="confirm_password" placeHolder="Please retype your password"
								class="form-control" />
						</div>
						<div class="white col-md-12 col-sm-12">
							<c:out value="Passwords need a minimum of 10 characters including at least one of each of the following: uppercase letter, lowercase letter, number"/>
						
						</div>
						
					</div>
					<br><div class = "alignmid">
						<button style = "mirgin-right: 10px; border-radius:10px" id="login_button" type="submit" class="btn btn-default">Create User</button>
					</div>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</form>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />