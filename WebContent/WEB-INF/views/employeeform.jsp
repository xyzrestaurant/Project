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
<title>Employee Form</title>
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
    <form:form action="processaddemployee" commandName="employeeForm">
    <table align="center" cellspacing="15">
    <tr>
         <td>First Name<FONT color="red"><form:errors path="firstName" /></FONT></td>
         <td><form:input path="firstName" /></td>
    </tr>
    <tr>
         <td>Last Name<FONT color="red"><form:errors path="lastName" /></FONT></td>
         <td><form:input path="lastName" /></td>
    </tr>
    <tr>
         <td>User Name<FONT color="red"><form:errors path="userName" /></FONT></td>
         <td><form:input path="userName" /></td>
    </tr>
    <tr>
         <td></td>
         <td><input type="submit" value="Submit" /></td>
    </tr>
    </table>
    </form:form>
    <br/><br/><br/><br/><br/><br/>
    </div>
    <c:import url="footer.jsp" />
</body>
</html>