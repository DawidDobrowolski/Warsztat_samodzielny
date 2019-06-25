<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/25/19
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<h2>Customers</h2>
<a href="/customers/add">Add new customer</a>
<br><br>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Birthday date</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.lastName}</td>
            <td>${customer.birthdayDate}</td>
            <td>
                <a href="/customers/details?id=${customer.id}">Details</a>
                <a href="/vehicles?id=${customer.id}">Vehicles</a>
                <a href="/customers/update?id=${customer.id}">Update</a>
                <a href="/customers/delete?id=${customer.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="fragments/footer.jspf"%>
</body>
</html>
