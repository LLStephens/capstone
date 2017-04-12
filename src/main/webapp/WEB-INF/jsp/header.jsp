<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width" />
	<c:url value="/css/style.css" var="cssHref" />
	<link rel="stylesheet" href="${cssHref}">
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
	<!-- verification -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	<script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	<script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	<c:url var="cssHref2" value="/css/override.css" />
	<link rel="stylesheet" type="text/css" href="${cssHref2}">
	    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>NPH</title>
</head>
<body >
	<nav class="navbar container-fluid ">
		<div class="container col-sm-3 zeros">	
			<div class="navbar-header">		
				<img id="logo" style = "height:40px; width:150px" src="img/ns3.png">		
				<button type="button" class="navbar navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" >
		      	<span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar bars"></span>
		        <span class="icon-bar bars"></span>
		        <span class="icon-bar bars"></span>	
		    	</button>
			</div>		
		</div>
		
		<div class="container col-sm-9 zeros">
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<c:url var="login" value="/login"/> 
					<c:url var="register" value="/register"/>
					<c:url var="provider" value="/providerLogin"/>
					<c:url var="home" value="/"/>
				
					<li><a id="zeros" class = "blackText" href="${home}">Home</a></li>
					<c:choose>
						<c:when test="${not empty currentPatientId}">
							<c:url var="logoutUrl" value="/logout"/>
							<li><form action="${logoutUrl}" method="POST"><input type="submit" value="Log Out"></form></li>
						</c:when>
						<c:otherwise>
							<li><a id="zeros" class = "blackText" href="${register}">Register</a></li>
							<li><a id="zeros" class = "blackText" href="${login}">Patient Login</a></li>
							<li><a id="zeros" class = "blackText" href="">Provider Portal</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>


