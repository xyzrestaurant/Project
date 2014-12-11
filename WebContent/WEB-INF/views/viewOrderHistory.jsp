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
<title>Order History</title>
</head>
<body background="${backURL}">
  <div id="wrap">
     <img src="${imgURL}" width="1000" height="150" alt="">
    <ul id="nav">
    <li> 
    <a href="<c:url value="customerhome">
             <c:param name='userName' value="${model.userName}"/>
         </c:url>">Home</a> 
    </li>
    <li>
    <form id="form2" action="customerMenu" method="GET">
            <input type="hidden" name="username" value="${model.userName}" />
            <a href="#" onclick="document.getElementById('form2').submit();" >Order Online</a>
    </form>
    </li>
    <li>
    <form id="orderhistory" action="customerOrderHistory" method="GET">
            <input type="hidden" name="username" value="${model.userName}" />
            <a href="#" onclick="document.getElementById('orderhistory').submit();" >Order History</a>
    </form>
    </li>
    <li>
    <form id="form1" action="retreivecustomerprofile" method="GET">
            <input type="hidden" name="userName" value="${model.userName}" />
             <a href="#" onclick="document.getElementById('form1').submit();" >Update Profile</a>   
    </form>
     </li>
     <li>
        <a href="loginform" onclick="return confirm('Are you sure you want to logout?');">Logout</a>
    </li>
    </ul>
    </div>
    <div id = "content" >
<br/><br/><br/><br/>
<table align="center" border="1" cellpadding=10 style="border-collapse:collapse;">
<tr>
    <th>Order Number</th>
    <th>Order Date</th>
    <th>Status </th> 
</tr>
<c:choose>
    <c:when test="${empty model.ordersList}"> 
        <br/>
        <tr> 
            <td/> <td/> 
            <td> No Orders Yet </td>
        </tr>
    </c:when>
    <c:otherwise>
        <c:forEach items="${model.ordersList}" var="order">
            <tr> 
                <td><c:out value="${order.orderNo}"/>  </td>
                <td><c:out value="${order.orderdate}"/></td>
                <td><c:out value="${order.status}"/></td>
                <td><a href="<c:url value="viewCustomerOrder">
                             <c:param name='userName' value="${model.userName}"/>
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