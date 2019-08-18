<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/25/19
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jspf"%>
<h3>Name: </h3>${employee.name}
<h3>Last name: </h3>${employee.lastName}
<h3>Address: </h3>${employee.address}
<h3>Phone: </h3>${employee.phone}
<h3>Note: </h3>${employee.note}
<h3>Cost per hour: </h3>${employee.costPerHour}
<%@include file="../../fragments/footer.jspf"%>
</body>
</html>
