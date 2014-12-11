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
<title>Update Profile</title>
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
    <form:form action="updatecustomer" commandName="CustomerForm" method="post">
    <table align="center" cellspacing="15">
    <tr>
	     <td>First Name</td>
	     <td><form:input path="firstName" /></td>
    </tr>
    <tr>
	     <td>Last Name</td>
	     <td><form:input path="lastName" /></td>
    </tr>
    <tr>
	     <td>User Name</td>
	     <td><form:input path="userName" /></td>
    </tr>
    <tr>
	     <td>Password</td>
	     <td><form:password path="password" /></td>
    </tr>
    <tr>
	     <td>Street</td>
	     <td><form:input path="street" /></td>
    </tr>
    <tr>
	     <td>City</td>
	     <td><form:input path="city" /></td>
    </tr>
    <tr>
	     <td>ZipCode</td>
	     <td><form:input path="pinCode" /></td>
    </tr>
    <tr>
	     <td>Mobile Number</td>
	     <td><form:input path="mobileNum" /></td>
    </tr>
    <tr>
         <td><input type="submit" value="Submit" /></td>
         <td><input type="button" value="Cancel" onclick="history.go(-1);" /></td>
    </tr>
    </table>
    </form:form>
    <br/><br/><br/><br/><br/><br/>
    </div>
    <c:import url="footer.jsp" />
</body>
</html>