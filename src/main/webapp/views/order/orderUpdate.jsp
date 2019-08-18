<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/23/19
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jspf"%>

<form method="post" action="/order/update">
    <div>
        <label>
        <h2>Entrance Date: </h2>
        <input type="date" name="entranceDate" value="${order.entranceDate}">
        </label>
    </div>
    <div>
        <label>
            <h2>Planned start date: </h2>
            <input type="date" name="planStartDate" value="${order.planStartDate}">
        </label>
    </div>
    <div>
        <label>
            <h2>Start date: </h2>
            <input type="date" name="startDate" value="${order.startDate}">
        </label>
    </div>
    <div>
        <h2>Employee: </h2>
        <select name="employee" >
            <c:forEach items="${employees}" var="emp">
                <option
                        <c:if test="${ex.id == order.employee.id}">selected</c:if>
                        value="${emp.id}">${emp.name} ${emp.lastName}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <h2>Problem description: </h2>
        <textarea name="problemDescription" rows="4" cols="50" placeholder="Problem description...">
${order.problemDescription}</textarea>
    </div>
    <div>
        <h2>Repair description: </h2>
        <textarea name="repairDescription" rows="4" cols="50" placeholder="Repair description...">
${order.repairDescription}</textarea>
    </div>
    <div>
        <h2>Status: </h2>
        <select name="status" >
            <c:forEach items="${statuses}" var="sta" varStatus="step">
                <option
                        <c:if test="${step.index == order.status.statusCode}">selected</c:if>
                        value="${step.index}">${sta}</option>
            </c:forEach>
        </select>
    </div>
    <div>
    <h2>Vehicle: </h2>
    <select name="vehicle" >
        <c:forEach items="${vehicles}" var="veh">
            <option
                    <c:if test="${veh.id == order.vehicle.id}">selected</c:if>
                    value="${veh.id}">${veh.brand} - ${veh.model} - ${veh.plateNumber}</option>
        </c:forEach>
    </select>
    </div>
    <div>
        <label>
            <h2>Repair cost: </h2>
            <input type="number" name="repairCost" step="0.1" value="${order.repairCost}">
        </label>
    </div>
    <div>
        <label>
            <h2>Parts cost: </h2>
            <input type="number" name="partsCost" step="0.1" value="${order.partsCost}">
        </label>
    </div>
    <div>
        <label>
            <h2>Number of hours: </h2>
            <input type="number" name="hoursNumber" value="${order.hoursNumber}">
        </label>
    </div>
    <br>
    <input type="submit" value="Order update">
</form>
<%@include file="../../fragments/footer.jspf"%>
</body>
</html>
