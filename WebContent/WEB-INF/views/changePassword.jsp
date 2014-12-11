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
<title>Change Password</title>
<script type = "text/javascript">
function valid() {	
	var pwd1 = document.form.password1.value;
	var pwd  = document.form.password.value;
	if((pwd=="") || (pwd1=="")) {
		alert("Empty field, Password length should be min 6 ");
		return false;
	}
	if(pwd1 != pwd) {
		alert("Password mismatch ");
		return false;
	} 
	return true;
	
};
</script>
</head>
<body background="${backURL}">
 <div id="wrap">
   <a href="showindex"><img src="${imgURL}" width="1000" height="150" alt=""></a> <br><br>
<br/><br/>
</div>
<div id="content">
    <form name="form" action="updatePwd" method="POST" onsubmit="return valid();">
    <table align="center" cellspacing="15">
    <tr>
        <td>New Password</td>
        <td><input type="password" name="password1" /></td>
    </tr>
    <tr>
        <td>Confirm Password</td>
        <td><input type="password" name="password"/></td>
    </tr>
    <tr>
        <td><input type="hidden" name="userName" value="${model.userName}" /></td>
        <td><input type="submit" value="Submit" /></td>
    </tr>
    </table>
    </form>
         <br/><br/><br/><br/><br/><br/>
</div>
  <c:import url="footer.jsp" />
</body>
</html>