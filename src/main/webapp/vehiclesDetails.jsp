<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/26/19
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<%@include file="fragments/header.jspf"%>
<h3>Model: </h3>${vehicle.model}
<h3>Brand: </h3>${vehicle.brand}
<h3>Production year: </h3>${vehicle.productionYear}
<h3>Plate numbers: </h3>${vehicle.plateNumber}
<h3>Date of next technical check: </h3>${vehicle.nextCheckDay}
<h3>Customer: </h3>${vehicle.customer}
<%@include file="fragments/footer.jspf"%>
</body>
</body>
</html>
