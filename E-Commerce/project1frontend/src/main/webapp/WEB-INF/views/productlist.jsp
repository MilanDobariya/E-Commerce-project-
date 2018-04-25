<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	$(document).ready(function() {
		var searchCondition = '${searchCondition}';
		$('.table').DataTable({
			"lengthMenu" : [ [  5, 7, -1 ], [  5, 7, "All" ] ],
			"oSearch" : {
				"sSearch" : searchCondition
			}
		})
	});
</script>
<title>Insert title here</title>
</head>
<body>

	<!-- for iteration - similar to for() in Java -->
	<!-- productsAttr is a model attribute, to which we have assigned List<Product> -->
	<!-- 
productsAttr -> 
p = 1 1000.0 Product Description for toy car Toy Car 12
2 1300.0 Product Description Book 2
 -->
	<div class="container">
		<b>List of Products</b>
		<table class="table table-hover" border="2">
			<thead id="thead">
				<tr>
				    <th>Image</th>
					<th>ProductName</th>
					<th>Category</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach items="${productsAttr }" var="p">
					<tr>
					  <td><img src='<c:url value="/resources/images/${p.id }.png" ></c:url>' alt="Image NA" height="50px" width="50px"></td>
						<!-- p.getProductName() -->
						<!-- p.getPrice() -->
						<td>${p.productname }</td>
						<!-- p.getCategory().getCategoryname() -->
						<td>${p.category.categoryname }</td>
						<td>${p.price }</td>
						<!-- http://...../all/getproduct/1 
					http://........../all/getproduct/2
					http://..../all/getproduct/3
					-->
						<!--  when glyphicon info sign is clicked, request
					 will be handled by the RequestMapping value 'all/getproduct/1 -->
						<td><a
							href='<c:url value="/all/getproduct/${p.id }"></c:url>'> <span
								class="glyphicon glyphicon-info-sign"></span></a> 

						<security:authorize access="hasRole('ROLE_ADMIN')" >
						<a href='<c:url value="/admin/deleteproduct/${p.id }"></c:url>'><span
								class="glyphicon glyphicon-trash" onclick="confirm('Are you sure')"></span></a>
								
						<a href='<c:url value="/admin/updateproductform/${p.id }"></c:url>'><span class="glyphicon glyphicon-pencil"></span></a>		
						</security:authorize>
						</td>
								
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>