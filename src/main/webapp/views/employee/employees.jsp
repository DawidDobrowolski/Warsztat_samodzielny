<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/25/19
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jspf" %>
<h2>Employees</h2>
<a href="/employees/add">Add new employee</a>
<br><br>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Phone</th>
        <th>Cost per hour</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.lastName}</td>
            <td>${employee.phone}</td>
            <td>${employee.costPerHour}</td>
            <td>
                <a href="/employees/details?id=${employee.id}">Details</a>
                <a href="/employees/orders?id=${employee.id}">Orders</a>
                <a href="/employees/update?id=${employee.id}">Update</a>
                <a href="/employees/delete?id=${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../../fragments/footer.jspf"%>
</body>
</html>
