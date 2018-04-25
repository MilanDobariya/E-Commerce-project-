<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:if test="${productNA !=null}">
The product ${productNA.productname } is not available and so removed from the cart
</c:if>
<div>
<div>
<a href="<c:url value='/cart/clearcart'></c:url>" class="btn btn-danger" pull-left  >
<span class="glyphicon glypicon-remove-sign"></span>
Clear Cart
</a>


<table class="table table-striped">
<thead id="thead">
<tr><th>ProductName</th><th>Quantity</th><th>Total Price</th><th>Remove</th>
</tr>
</thead>
<!-- double grandTotal=0 -->
<c:set var="grandTotal" value="0"></c:set>
<tbody id="tbody">
<c:forEach items="${cartItems }" var="cartItem">
<tr>
<td>${cartItem.product.productname }</td>
<td>${cartItem.quantity }</td>
<td>${cartItem.totalPrice }</td>

<td><a href="<c:url value='/cart/deletecartitem/${cartItem.cartitemid }'></c:url>" class="label label-danger" pull-left>

<span class="glyphicon glyphicon-remove" ></span>Remove
</a></td>
<!--  grandTotal = cartItem.totalPrice + grandTotal -->

<c:set var="grandTotal" value="${grandTotal + cartItem.totalPrice }"></c:set>
</tr>
<hr>
</c:forEach>
</tbody>
</table>
Total Price : ${grandTotal }
</div>
<c:if test="${empty(cartItems) }">
<h3>Your Cart is empty</h3>
</c:if>
<c:if test="${!empty(cartItems)}">
<a href="<c:url value='/cart/checkout'></c:url>" class="btn btn-success pull-right">
<span class="glyphicon glyphicon-shopping-cart"></span> Place Order  </a>
</c:if>
</div>
</body>
</html>

