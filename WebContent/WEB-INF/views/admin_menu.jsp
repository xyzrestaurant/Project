<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@page import="com.example.controllers.*, com.example.bean.ItemBean,java.util.ArrayList,java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/css/style2.css" var="cssURL"/>
<c:url value="/resources/Images/Banner_01.gif" var="imgURL" />
<c:url value="/resources/Images/back3.jpg" var="backURL"/>
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Menu Maintenance</title>
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
<table align="center" border="1" cellpadding=10 style="border-collapse:collapse;">
<tr>
    <th>Item Number</th>
    <th>Item Name</th>
    <th>Description</th>
    <th>Price</th>
    <th>Status</th>
    <th> Update item </th>
    <th> Item status </th>
    <th> Delete Item </th>
</tr>
<c:choose>
<c:when test="${empty itemlists}"> 
     <br/>
    <tr> <td/> <td/> <td> No items to display </td> </tr>
 </c:when>
<c:otherwise>
<c:forEach items="${itemlists}" var="item">
<tr>
    <td><c:out value="${item.itemNo}"/>  </td>
    <td><c:out value="${item.itemName}"/></td>
    <td><c:out value="${item.description}"/></td>
    <td>$<c:out value="${item.price}"/></td>
    <td><c:out value="${item.status}"/></td>
    <td><form id="update" action="retrieveitem" method="get">
         <button class="linkstyle" type=submit name='itemNumber' value="${item.itemNo}">Update</button>
        </form> </td>
    <c:choose>
     <c:when test = "${item.status == 'available'}">   
       <td><form id="status" action="statuschange" method="post">
               <button class="linkstyle" type=submit name='itemNumber' value="${item.itemNo}">Make Unavailable</button>
           </form>
       </td>
     </c:when>
     <c:otherwise>
       <td><form id="status" action="statuschange" method="post">
                <button class="linkstyle" type=submit name='itemNumber' value="${item.itemNo}">Make available</button>
           </form>
       </td>
     </c:otherwise>
   </c:choose>  
    <td><form id="delete" action="deleteitem" method="post">
        <button class="linkstyle" type=submit name='itemNumber' value="${item.itemNo}">Delete</button>
        </form>
    </td>
</tr>
</c:forEach>
</c:otherwise> 
</c:choose>
</table>
     <br/><br/><br/><br/><br/><br/></div>
  <c:import url="footer.jsp" />
</body>
</html>