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
<title>Login Form</title>
</head>
<body background="${backURL}">
 <div id="wrap"> 
 <a href="showindex"><img src="${imgURL}" width="1000" height="150" alt=""></a> <br><br><br/><br/>
 </div>
 <div id="content">
  <c:if test="${success == false }">
      <script>alert("Invalid username or password, Login failed..!!");
  </script></c:if>
      <form:form action="loginform" commandName="loginForm">
      <table align="center" cellspacing="15">
      <tr>
           <td>User Name:<FONT color="red"><form:errors path="userName" /></FONT></td>
           <td><form:input path="userName" /></td>
      </tr>
      <tr>
           <td>Password:<FONT color="red"><form:errors path="password" /></FONT></td>
           <td><form:password path="password" /></td>
      </tr>
      <tr>
      <td> </td>
      <td><input type="submit" value="Submit" /></td>
      </tr>
      </table>
      </form:form>
           <br/><br/><br/><br/><br/><br/>
  </div>
    <c:import url="footer.jsp" />
</body>
</html>