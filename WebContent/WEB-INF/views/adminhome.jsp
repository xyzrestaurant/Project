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
<c:url value="/resources/Images/Item1.jpg" var="item1URL" />
<c:url value="/resources/Images/Item2.jpg" var="item2URL" />
<c:url value="/resources/Images/Item3.jpg" var="item3URL" />
<c:url value="/resources/Images/Item4.jpg" var="item4URL" />
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Admin Home Page</title>
</head>
<body background="${backURL}">
   <div id="wrap">
     <img src="${imgURL}" width="1000" height="150" alt="">
    <ul id="nav">
    <li>   
        <a href="adminsuccess">Home</a>
    </li>
    <li> 
        <a href="addemployee">Add Employee</a>
    </li>
    <li>
        <a href="displayadditem">Add Item</a>
    </li>
    <li>
        <a href="viewMenu">Menu Management</a>
    </li>
    <li>
        <a href="viewAllOrders">View all orders</a>
    </li>
    <li>   
        <a href="loginform" onclick="return confirm('Are you sure you want to logout?');">Logout</a>
    </li>
    </ul>
    </div>
    <div id="content">
    <h2>Welcome Administrator  </h2>
         <br/><br/>
     <img src="${item1URL}" width="240" height="220" alt="">
     <img src="${item2URL}" width="240" height="220" alt="">
     <img src="${item3URL}" width="240" height="220" alt="">
     <img src="${item4URL}" width="240" height="220" alt="">
         <br/><br/><br/>
    </div>
      <c:import url="footer.jsp" />
</body>

</html>