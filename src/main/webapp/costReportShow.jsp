<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/27/19
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf"%>
<h2>Profit analysis between ${startDate} and ${endDate} </h2>
<h3>Total income: </h3>${repairCost}
<h3>Total costs: </h3>${totalCost}
<h5>Parts costs: ${partsCost}</h5>
<h5>Employee costs: ${employeeCost}</h5>
<h3>Profit: </h3>${profit}
<h3>Profit margin: </h3>${margin} %
<h5>Number of hours worked: ${hoursNumber}</h5>
<%@include file="fragments/footer.jspf"%>
</body>
</html>
