<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/26/19
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>

<form method="post" action="/vehicles/update">
    <div>
        <label>
            <h2>Model: </h2>
            <input type="text" name="model" value="${vehicle.model}">
        </label>
    </div>
    <div>
        <label>
            <h2>Brand: </h2>
            <input type="text" name="brand" value="${vehicle.brand}">
        </label>
    </div>
    <div>
        <label>
            <h2>Production year: </h2>
            <input type="number" name="productionYear" value="${vehicle.productionYear}">
        </label>
    </div>
    <div>
        <label>
            <h2>Plate numbers: </h2>
            <input type="text" name="plateNumber" value="${vehicle.plateNumber}">
        </label>
    </div>
    <div>
        <label>
            <h2>Date of next technical check: </h2>
            <input type="date" name="nextCheckDay" value="${vehicle.nextCheckDay}">
        </label>
    </div>
    <br>
    <input type="submit" value="Update vehicle">
</form>
<%@include file="fragments/footer.jspf" %>
</body>
</html>
