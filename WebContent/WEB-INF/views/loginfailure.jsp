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
<title>XYZ Restaurant</title>
</head>
<body onLoad="failed()">
 <div id="wrap">
     <img src="${imgURL}" width="1000" height="150" alt="">
<form id="login" action="loginform" ></form>
</div>

</body>
  <script type="text/javascript">
  function failed() {
  alert("Login failed");
  var frm = document.getElementById("login");
  frm.submit();
  }
</script>
</html>