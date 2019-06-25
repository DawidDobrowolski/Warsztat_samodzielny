<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/25/19
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<h2>Vehicles owned by ${customer.name} ${customer.lastName}</h2>
<a href="/vehicles/add?id=${customer.id}">Add new vehicle</a>
<br><br>

<table border="1">
    <tr>
        <th>Model</th>
        <th>Brand</th>
        <th>Production year</th>
        <th>Plate numbers</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${vehicles}" var="vehicle">
        <tr>
            <td>${vehicle.model}</td>
            <td>${vehicle.brand}</td>
            <td>${vehicle.productionYear}</td>
            <td>${vehicle.plateNumber}</td>
            <td>
                <a href="/vehicles/details?id=${vehicle.id}">Details</a>
                <a href="/vehicles/update?id=${vehicle.id}">Update</a>
                <a href="/vehicles/delete?id=${vehicle.id}&idCus=${customer.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="fragments/footer.jspf"%>
</body>
</html>
