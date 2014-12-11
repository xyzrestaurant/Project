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
<title>Sign up</title>

<script>

function validateForm() {
    var fname = document.forms["customerForm"]["firstName"].value;
    if (fname==null || fname=="") {
        alert("Enter First Name");
        return false; 
    }
    var lname = document.forms["customerForm"]["lastName"].value;
    if (lname==null || lname=="") {
        alert("Enter Last name");
        return false; 
    }    
    var uname = document.forms["customerForm"]["userName"].value;
    if (uname.length < 6 || uname.length > 15) 
    {
    alert("Username must be between 6 to 15 characters");
        return false;
    }
    var invalid = " "; 
    var pwd = document.forms["customerForm"]["password"].value;
    if (pwd == '') {
    alert('Please enter your password.');
    return false;
    }
    if ((pwd.length < 7) || (pwd.length > 15)) {
        alert('Your password must be between 7 to 15 characters long. Try again.');
        return false;
    }    
    if ((pwd.search(/[a-zA-Z]+/)==-1) || (pwd.search(/[0-9]+/)==-1)) {
        alert('The password must contain at least one numeral');
        return false;
    }    
    if (pwd.indexOf(invalid) > -1) {
    alert("Spaces are not allowed in password.");
    return false;
    }      
    var street = document.forms["customerForm"]["street"].value;
    if (street==null || street=="" ) {
        alert("Street field must be filled out");
        return false; 
    }
    var city = document.forms["customerForm"]["city"].value;
    if (city==null || city=="" ) {
        alert("City must be filled out");
        return false; 
    }
    var zip = document.forms["customerForm"]["pinCode"].value;
    if(zip.length != 5 || isNaN(zip) ){
       alert("Zip Code must be of 5 digits e.g. 12345");
       return false; 
    }    
    var number = document.forms["customerForm"]["mobileNum"].value;
     if(number.length != 10 || isNaN(number) ){
        alert("Mobile Number must be of 10 integer digits");
        return false; 
    }
}
</script>
</head>
<body background="${backURL}">
<div id="wrap"> 
    <a href="showindex"><img src="${imgURL}" width="1000" height="150" alt=""></a> <br><br><br/><br/>
</div>
<div id="content">
<form:form onsubmit="return validateForm()" action="addcustomer" commandName="customerForm">
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
</tr>
</table>
</form:form>
     <br/><br/><br/><br/><br/><br/>
</div>
  <c:import url="footer.jsp" />
</body>
</html>