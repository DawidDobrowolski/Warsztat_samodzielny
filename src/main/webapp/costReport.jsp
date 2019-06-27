<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/27/19
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf"%>
<h2>Please set data for Cost Report</h2>
<form method="post" action="/costReport">
    <div>
        <label>
            <h2>Start Date: </h2>
            <input type="date" name="startDate">
        </label>
    </div>
    <div>
        <label>
            <h2>End Date: </h2>
            <input type="date" name="endDate">
        </label>
    </div>
    <br>
    <input type="submit" value="Show report">
</form>
<%@include file="fragments/footer.jspf"%>
</body>
</html>
