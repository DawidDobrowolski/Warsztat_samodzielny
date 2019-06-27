<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/27/19
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<h2>Number of hours by Employees between "${startDate}" and "${endDate}" </h2>
<br><br>
<table border="1">
    <tr>
        <th>Employee</th>
        <th>Number of hours</th>
    </tr>
    <c:forEach items="${employeeReports}" var="employeeReport">
        <tr>
            <td>${employeeReport.employee.name} ${employeeReport.employee.lastName}</td>
            <td>${employeeReport.hoursSum}</td>
        </tr>
    </c:forEach>
</table>
<%@include file="fragments/footer.jspf"%>
</body>
</html>
