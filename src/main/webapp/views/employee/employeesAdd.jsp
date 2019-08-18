<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/25/19
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jspf"%>

<form method="post" action="/employees/add">
    <div>
        <label>
            <h2>Name: </h2>
            <input type="text" name="name">
        </label>
    </div>
    <div>
        <label>
            <h2>Last name: </h2>
            <input type="text" name="lastName">
        </label>
    </div>
    <div>
        <label>
            <h2>Address: </h2>
            <input type="text" name="address">
        </label>
    </div>
    <div>
        <label>
            <h2>Phone: </h2>
            <input type="number" name="phone">
        </label>
    </div>
    <div>
        <h2>Note: </h2>
        <textarea name="note" rows="4" cols="50" placeholder="Note...">
</textarea>
    </div>
    <div>
        <label>
            <h2>Cost per hour: </h2>
            <input type="number" name="costPerHour" step="0.1">
        </label>
    </div>
    <br>
    <input type="submit" value="Add employee">
</form>
<%@include file="../../fragments/footer.jspf"%>
</body>
</html>
