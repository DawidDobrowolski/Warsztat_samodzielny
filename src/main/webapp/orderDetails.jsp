<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/23/19
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf"%>
<h3>Entrance Date: </h3>${order.entranceDate}
<h3>Planned start date: </h3>${order.planStartDate}
<h3>Start date: </h3>${order.planStartDate}
<h3>Employee: </h3>${order.employee.name} ${order.employee.lastName}
<h3>Problem description: </h3>${order.problemDescription}
<h3>Repair description: </h3>${order.repairDescription}
<h3>Status: </h3>${order.status.statusName}
<h3>Vehicle: </h3>${order.vehicle.brand} - ${order.vehicle.model} - ${order.vehicle.plateNumber}
<h3>Repair cost: </h3>${order.repairCost}
<h3>Parts cost: </h3>${order.partsCost}
<h3>Number of hours: </h3>${order.hoursNumber}
<h3>Cost per hour: </h3>${order.costPerHour}
<%@include file="fragments/footer.jspf"%>
</body>
</html>
