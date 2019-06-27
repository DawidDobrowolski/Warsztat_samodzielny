<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/24/19
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf"%>
<form method="post" action="/order/add">
    <div>
        <label>
            <h2>Entrance Date: </h2>
            <input type="date" name="entranceDate">
        </label>
    </div>
    <div>
        <label>
            <h2>Planned start date: </h2>
            <input type="date" name="planStartDate">
        </label>
    </div>
    <div>
        <label>
            <h2>Start date: </h2>
            <input type="date" name="startDate">
        </label>
    </div>
    <div>
        <h2>Employee: </h2>
        <select name="employee" >
            <c:forEach items="${employees}" var="emp">
                <option value="${emp.id}">${emp.name} ${emp.lastName}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <h2>Problem description: </h2>
        <textarea name="problemDescription" rows="4" cols="50" placeholder="Problem description...">
</textarea>
    </div>
    <div>
        <h2>Repair description: </h2>
        <textarea name="repairDescription" rows="4" cols="50" placeholder="Repair description...">
</textarea>
    </div>
    <div>
    <h2>Vehicle: </h2>
    <select name="vehicle" >
        <c:forEach items="${vehicles}" var="veh">
            <option value="${veh.id}">${veh.brand} - ${veh.model} - ${veh.plateNumber}</option>
        </c:forEach>
    </select>
    </div>
    <div>
        <label>
            <h2>Repair cost: </h2>
            <input type="number" name="repairCost" step="0.1">
        </label>
    </div>
    <div>
        <label>
            <h2>Parts cost: </h2>
            <input type="number" name="partsCost" step="0.1">
        </label>
    </div>
    <div>
        <label>
            <h2>Number of hours: </h2>
            <input type="number" name="hoursNumber">
        </label>
    </div>
    <br>
    <input type="submit" value="Add order">
</form>
<%@include file="fragments/footer.jspf"%>
</body>
</html>
