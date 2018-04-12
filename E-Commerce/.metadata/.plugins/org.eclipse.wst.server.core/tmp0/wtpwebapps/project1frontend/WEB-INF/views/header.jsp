<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/sample.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse">  <!-- nav bar bleck color -->
	<div class="container-fluid">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#collapse-example"
			aria-expanded="false">     <!-- button at time when click to mouse -->
			<span class="sr-only">Toggle navigation</span>
			 <span class="icon-bar"></span>
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span>
		</button>
		<div class="navbar-header">
		<!-- mapping/resources/**  -> /resources/images/niit.jpg
		/WEB-INF/resources/images/niit.jpg -->
		<!-- 	<a class="navbar-brand" href=""><img src="resources/images/DreamArea.png"
				alt="NIIT" height="30px" width="120px"></a>
		 -->
		<a class="navbar-brand" href=""><img src='<c:url value="/resources/images/DreamArea.png"></c:url>'
				alt="NIIT" height="30px" width="120px"></a>
		</div>
		<div class="collapse navbar-collapse" id="collapse-example">
			<ul class="nav navbar-nav">
				<li class="active"><a href='<c:url value="/home"></c:url>'>Home</a></li>
				<li><a href='<c:url value="/all/getproducts"></c:url>'>Browser All Products</a></li>
				<li><a href='<c:url value="/admin/getproductform"></c:url>'>Add Product</a></li>
				<!--  <li><a href="">sign in</a></li>   
				 <li><a href="">sign up</a></li>
				<li class="dropdown"><a href="" class="dropdown-toggle"
					data-toggle="dropdown">Select by Categories<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="">General</a></li>
						<li><a href="">Discount sale</a></li>
						<li><a href="">Special edition</a></li>
					</ul></li> -->
			</ul>
			
		</div>
	</div>
	</nav>
</body>
</html>
