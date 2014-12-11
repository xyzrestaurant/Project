<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.example.controllers.*, com.example.bean.ItemBean,java.util.ArrayList,java.util.Iterator" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/css/style2.css" var="cssURL"/>
<c:url value="/resources/Images/Banner_01.gif" var="imgURL" />
<c:url value="/resources/Images/back3.jpg" var="backURL"/>
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Update Item</title>
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
    <form:form action="updateItem" commandName ="itemBean" method="post" >
    <div class="center">
    <table  align="center" border="1" cellpadding=10 style="border-collapse:collapse;">
    <tr>
        <td>Item Number</td>
        <td><form:input path="itemNo" /></td>
    </tr>
    <tr>
        <td>Item Name</td>
        <td><form:input path="itemName" /></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><form:input path="description" /></td>
    </tr>
    <tr>
        <td>Price</td>
        <td><form:input path="price" /></td>
    </tr>
    <tr>
        <td>Status</td>
        <td><form:input path="status" disabled ="true"/></td>
    </tr>
    <tr>
        <td> </td>
        <td><input type="submit" value="Submit" /></td>
    </tr>
    </table>
    </div>
    </form:form>
    <br/><br/><br/><br/><br/><br/>
    </div>
      <c:import url="footer.jsp" />
</body>
</html>