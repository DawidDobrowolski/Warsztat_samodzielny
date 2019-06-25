<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/25/19
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<h2>Orders for employee: ${employee.name} ${employee.lastName}</h2>
<table border="1">
    <tr>
        <th>Entrance date</th>
        <th>Status</th>
        <th>Vehicle</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${employeeOrders}" var="order">
        <tr>
            <td>${order.entranceDate}</td>
            <td>${order.status.statusName}</td>
            <td>${order.vehicle.plateNumber}</td>
            <td>
                <a href="/order/details?id=${order.id}">Details</a>
                <a href="/order/update?id=${order.id}">Update</a>
                <a href="/order/delete?id=${order.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="fragments/footer.jspf"%>
</body>
</html>
