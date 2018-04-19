<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href='<c:url value="/resources/css/registration.css"></c:url>'>
</head>
<body>
<div class="container">
<c:url var="url" value="/all/registercustomer"></c:url>
<form:form modelAttribute="customer" action="${url }">
<p align="center"><b>Customer Details</b></p>
<form:label path="id"></form:label>
<form:hidden path="id"/>


<form:label path="firstname">Enter Firstname</form:label>
<form:input path="firstname"/>


<form:label path="lastname">Enter lastname</form:label>
<form:input path="lastname"/>


<form:label path="phonenumber">Enter phonenumber</form:label>
<form:input path="phonenumber"/>

<hr>
<p align="center"><b>Login credentials</b><br></p>
<form:label path="user.email">Enter Email </form:label>
<form:input path="user.email"/>

<form:label path="user.password">Enter password</form:label>
<form:input path="user.password"/>
<hr>
<p align="center"><b>Billing Address</b><br></p>
<form:label path="billingaddress.apartmentnumber">Enter Apartmentnumber</form:label>
<form:input path="billingaddress.apartmentnumber"/>

<form:label path="billingaddress.streetname">Enter Streetname</form:label>
<form:input path="billingaddress.streetname"/>

<form:label path="billingaddress.city">Enter city</form:label>
<form:input path="billingaddress.city"/>

<form:label path="billingaddress.state">Enter State</form:label>
<form:input path="billingaddress.state"/>

<form:label path="billingaddress.country">Enter country</form:label>
<form:input path="billingaddress.country"/>

<form:label path="billingaddress.zipcode">Enter zipcode</form:label>
<form:input path="billingaddress.zipcode"/>

<hr>
<p align="center"><b>Shipping Address</b></p>	

<form:label path="shippingaddress.apartmentnumber">Enter Apartmentnumber</form:label>
<form:input path="shippingaddress.apartmentnumber"/>


<form:label path="shippingaddress.streetname">Enter Streetname</form:label>
<form:input path="shippingaddress.streetname"/>


<form:label path="shippingaddress.city">Enter city</form:label>
<form:input path="shippingaddress.city"/>


<form:label path="shippingaddress.state">Enter State</form:label>
<form:input path="shippingaddress.state"/>


<form:label path="shippingaddress.country">Enter country</form:label>
<form:input path="shippingaddress.country"/>


<form:label path="shippingaddress.zipcode">Enter zipcode</form:label>
<form:input path="shippingaddress.zipcode"/>


<button type="submit" >Register</button>
</form:form>
</div>
</body>
</html>


