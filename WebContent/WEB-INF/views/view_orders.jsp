<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/css/style2.css" var="cssURL"/>
<c:url value="/resources/Images/Banner_01.gif" var="imgURL" />
<c:url value="/resources/Images/back3.jpg" var="backURL"/>
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Orders List</title>
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
<table align="center" border="1" cellpadding=10 style="border-collapse:collapse;">
<tr>
    <th>Order Number</th>
    <th>Order Date</th>
    <th>Status </th> 
</tr>
<c:choose>
<c:when test="${empty model.ordersList}"> 
     <br/>
    <tr> <td/> <td/> <td> No Orders Yet </td> </tr>
 </c:when>
<c:otherwise>
<c:forEach items="${model.ordersList}" var="order">
<tr> 
    <td><c:out value="${order.orderNo}"/>  </td>
    <td><c:out value="${order.orderdate}"/></td>
    <td><c:out value="${order.status }"/></td>
    <td><a href="<c:url value="viewOrder2">
             <c:param name='orderNumber' value="${order.orderNo}"/>
         </c:url>">View Order</a> </td>
</tr>
</c:forEach>
</c:otherwise> 
</c:choose> 
</table>
     <br/><br/><br/><br/><br/><br/>
</div>
  <c:import url="footer.jsp" />
</body>
</html>