<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<c:url var="cssHref2" value="/css/override.css" />
<link rel="stylesheet" type="text/css" href="${cssHref2}">
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NPH</title>

</head>
<body>

<nav class="navbar navbar-inverse container-fluid">
	<div class="container col-sm-3 zeros">	
		<div class="navbar-header" >		
		<img id="logo" style = "height:75px; width:100px" src="img/ns2.png">		
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"> <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>	
		</div>		
  </div> 
  
  <div class="container col-sm-9 zeros">
	<div id="navbar" class="navbar-collapse collapse">
     		 <ul class="nav navbar-nav navbar-right">
      		 <li ><a id="zeros" href="#welcome">Register</a></li>
      		 <li ><a id="zeros" href="#features">Patient Login</a></li>
      		 <li ><a id="zeros" href="#impact">Provider Portal</a></li>
    	 	 </ul>
   	 	
		</div>
  </div>
</nav>

<div class="container-fluid">
		<!-- <img class = "headerPic" src="img/background.png"> -->
</div>