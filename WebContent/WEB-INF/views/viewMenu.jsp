<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/css/style2.css" var="cssURL"/>
<c:url value="/resources/Images/Banner_01.gif" var="imgURL" />
<c:url value="/resources/Images/back3.jpg" var="backURL"/>
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Menu Display</title>
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
   <div id="content">
    <table  border="1" cellpadding=10 style="border-collapse:collapse;" >
    <tr>
        <td>
            <table  border="1" cellpadding=10 style="border-collapse:collapse;" >
            <tr>
                 <th>Item Name</th>
                 <th>Description</th>
                 <th>Price</th>
            </tr>
            <c:forEach items="${model.itemlists}" var="item">
            <tr>
            <c:if test = "${item.status == 'available'}">   
                 <td><c:out value="${item.itemName}"/></td>
                 <td><c:out value="${item.description}"/></td>
                 <td><c:out value="${item.price}"/></td>
                 <td><form id="additem" action="additemtocart" method="post">
                     <input type="hidden" name="userName" value="${model.userName}" />
                     <button class="linkstyle" type=submit name='itemNumber' value="${item.itemNo}">Add item to Cart</button>
                     </form> </td>
            </c:if>
            </tr>
            </c:forEach>
            </table>
        </td>
        <td> </td><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td>
        <td>
            <table border="1" cellpadding=10 style="border-collapse:collapse;">
            <tr></tr><tr></tr><tr></tr>
            <tr>       
                 <th>   </th>
                 <th> Cart </th>
            </tr>
            <c:choose> 
            <c:when test="${model.orderItem.totalAmount == '0.0' }">  
            <tr>
                 <td> </td>
                 <td>Empty Cart </td>
            </tr>
            </c:when>
            <c:otherwise>
            <tr>
                 <th>Item Name</th>
                 <th> Quantity </th>
                 <th>Price </th>
            </tr>
            <c:forEach items="${model.orderItem.itemList}" var="cart">
            <tr>    
                 <td><c:out value="${cart.itemName}"/></td>
                 <td><c:out value="${cart.qty}"/></td>  
                 <td>$<c:out value="${cart.price}"/></td>
            </tr>
            </c:forEach>
            <tr>    
                 <td>Total Price</td>
                 <td>  </td>
                 <td>$<c:out value="${model.orderItem.totalAmount}"/></td>
            </tr> 
            <tr>
                 <td><form id="editcart" action="editCart" method="get">
                      <button type=submit class="mybutton" name='userName' value="${model.userName}">Edit Cart</button> </form> 
                 </td>
                 <td><form id="form3" action="createOrder" onsubmit="return confirm('Are you sure you want to Order?');" method="post">
                      <button type=submit class="mybutton" name='userName'  value="${model.userName}">Order</button>
                      </form>
                 </td>
            </tr>
            </c:otherwise>
            </c:choose>
            </table>
            <br/><br/><br/><br/><br/><br/>
        </td>
    </tr>
    </table> 
    </div>
    <c:import url="footer.jsp" />
</body>
</html>