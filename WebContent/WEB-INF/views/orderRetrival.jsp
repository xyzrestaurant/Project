<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/css/style2.css" var="cssURL"/>
<c:url value="/resources/Images/Banner_01.gif" var="imgURL" />
<c:url value="/resources/Images/back3.jpg" var="backURL"/>
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Retrieve Order</title>
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
    <h3>Enter Order Number:</h3>
    <form action="searchOrder" method="GET">
    <table align="center" cellspacing="15">
    <tr>
        <td>Order Number:</td>
        <td><input type="text" name="orderNumber" /></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Submit" /></td>
    </tr>
    </table>
    </form>
         <br/><br/><br/><br/><br/><br/>
    </div>
    <c:import url="footer.jsp" />
</body>

</html>