<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/css/style2.css" var="cssURL"/>
<c:url value="/resources/Images/Banner_01.gif" var="imgURL" />
<c:url value="/resources/Images/back3.jpg" var="backURL"/>
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Order Details</title>
</head>
<body background="${backURL}">
 <div id="wrap">
     <img src="${imgURL}" width="1000" height="150" alt="">
    <ul id="nav">
    <li>
    <a href="employeesuccess">Home</a>
    </li>
    <li> 
    <a href="orderRetrival">Search Order</a>
    </li>
    <li>
    <form id="form3" action="viewOrders" method="GET">
        <a href="#" onclick="document.getElementById('form3').submit();" >View all orders</a>
    </form>
    </li>
    <li>
    <div class="right">
        <a href="loginform" onclick="return confirm('Are you sure you want to logout?');">Logout</a>
    </div>
    </li>
    </ul>
    </div>
    <div id="content">
<form id="redirect" action="orderRetrival" method="get"  ></form>
 <c:if test="${model.success2 == false }">
  <script>
  alert("Order not found !! ");
  var frm = document.getElementById("redirect");
  frm.submit();
</script></c:if>
<table align="center" class="order" border="1" cellpadding=10 style="border-collapse:collapse;">
<tr>
    <th> </th>
    <th> Order Summary </th>

  <c:choose>
       <c:when test= "${model.orderItem.status == 'In Process' }">
           <td><form id="orderstatus" action="updateOrderStatusemployee" method="post">
               <input type="hidden" name="status" value="Cancelled"  />
               <input type="hidden" name="userName" value="${model.userName}" />
               <button class="linkstyle" type=submit name='orderNumber' value="${model.orderItem.orderNo}">Cancel Order</button>
               </form> 
          </td>
          <td><form id="orderstatus" action="updateOrderStatusemployee" method="post">
              <input type="hidden" name="status" value="Completed"  />
              <input type="hidden" name="userName" value="${model.userName}" />
              <button class="linkstyle" type=submit name='orderNumber' value="${model.orderItem.orderNo}">Complete Order</button>
              </form>   
          </td>  
       </c:when>
  </c:choose>
  <c:if test="${model.success == true }">
      <script>alert("${model.orderItem.orderNo} ${model.status} ");</script>
  </c:if>
  </tr>
  <tr></tr><tr></tr><tr></tr>
  <tr>
       <th> ${model.orderItem.orderNo} </th>
       <th> Date:  ${model.orderItem.orderdate} </th>
       <th> Status: ${model.orderItem.status } </th>
  </tr>
  <tr></tr> <tr></tr>
  <tr>
      <th>Item Name</th>
      <th> Quantity </th>
      <th>Price </th>
   </tr>
   <c:if test="${not empty model.orderItem}">
   <c:forEach items="${model.orderItem.itemList}" var="item">
   <tr>
        <td><c:out value="${item.itemName}"/></td>
        <td><c:out value="${item.qty}"/></td>
        <td><c:out value="${item.price}"/></td>
   </tr>
   </c:forEach>
   </c:if> 
   <tr></tr>
   <tr> 
        <td></td>   
        <td>Total Price</td>
        <td><c:out value="${model.orderItem.totalAmount}"/></td>
   </tr>
   </table>
   <br/><br/><br/><br/><br/><br/>
    </div>
      <c:import url="footer.jsp" />
   </body>

</html>