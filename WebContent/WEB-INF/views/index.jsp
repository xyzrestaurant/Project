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
<c:url value="/resources/Images/Item1.jpg" var="item1URL" />
<c:url value="/resources/Images/Item2.jpg" var="item2URL" />
<c:url value="/resources/Images/Item3.jpg" var="item3URL" />
<c:url value="/resources/Images/Item4.jpg" var="item4URL" />
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>XYZ Restaurant</title>
</head>
<body background="${backURL}">
 <div id="wrap">
     <img src="${imgURL}" width="1000" height="150" alt="">
   <ul id="nav">
    <li>
        <a href="loginform">Login Form</a>
    </li>
    <li>
        <a href="signup">New Sign up </a>
    </li>
    </ul>
     <h2>Welcome to XYZ Restaurant</h2>
     <br><br>
     <img src="${item1URL}" width="240" height="220" alt="">
     <img src="${item2URL}" width="240" height="220" alt="">
     <img src="${item3URL}" width="240" height="220" alt="">
    <img src="${item4URL}" width="240" height="220" alt="">
</div>
<c:import url="footer.jsp" />
</body>
</html>