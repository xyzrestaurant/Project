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
<title>Home page</title>
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
    <br>
    <h2>Welcome ${model.userName}</h2>
     <br/><br/>
    <img src="${item1URL}" width="240" height="220" alt="">
     <img src="${item2URL}" width="240" height="220" alt="">
     <img src="${item3URL}" width="240" height="220" alt="">
    <img src="${item4URL}" width="240" height="220" alt="">
         <br/><br/>
    </div>
</body>
  <c:import url="footer.jsp" />
</html>