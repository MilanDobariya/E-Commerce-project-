<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<%@ page isELIgnored="false" %>
<jsp:useBean id="now" class="java.util.Date" />

<div class="container-wrapper">
    <div class="container">
    
       
        <div class="container">
        
<form:form action="${url }" modelAttribute="order">
            <div class="row">

                             <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

                       <div >
                            <h1 align="center">Invoice</h1>
                       </div>
                        ORDER ID: ${order.orderid }
                  
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong><button disabled>Shipping Address</button></strong><br/>
                                    ${order.user.customer.shippingaddress.streetname}
                                <br/>
                                    ${order.user.customer.shippingaddress.city}, ${order.user.customer.shippingaddress.state}
                                <br/>
                                   ${order.user.customer.shippingaddress.zipcode}
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p>Shipping Date: ${order.purchaseDate }</p>
                            </div>
                        </div>
                       <hr>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong><button disabled>Billing Address</button></strong><br/>
                                        ${order.user.customer.billingaddress.streetname}
                                    <br/>
                                        ${order.user.customer.billingaddress.city}, ${order.user.customer.billingaddress.state}
                                    <br/>
                                        ${order.user.customer.billingaddress.zipcode}
                                </address>
                            </div>
                        </div>

                        <div class="row">
                            <table class="table table-hover" border="1">
                                <thead>
                                    <tr>
                                        <td>Image</td>
                                        <td>Product</td>
                                        <td>Units</td>
                                        <td class="text-center">Price</td>
                                        <td class="text-center">Total</td>
                                    </tr>
                                </thead>
                                <tbody>
                              
                                <c:forEach var="cartItem" items="${order.user.cartItems}">
                                    <tr>
                            <c:url value="/resources/images/${cartItem.product.id }.png" var="imgUrl"></c:url>
                                        <td><img src="${imgUrl }" height="50px" width="50px">  </td>
                                        <td class="col-md-9"><em>${cartItem.product.productname}</em></td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.product.price}</td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.totalPrice}</td>
                                       
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total:</strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>Rs. ${order.grandTotal}</strong></h4>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                           
                        </div>


                      
                    </div>
             
            </div>
            
            </form:form>
        </div>
        </div>
        </div>
