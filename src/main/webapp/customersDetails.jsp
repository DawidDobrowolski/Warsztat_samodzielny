<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/25/19
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf"%>
<h3>Name: </h3>${customer.name}
<h3>Last name: </h3>${customer.lastName}
<h3>Birthday date: </h3>${customer.birthdayDate}
<%@include file="fragments/footer.jspf"%>
</body>
</html>
