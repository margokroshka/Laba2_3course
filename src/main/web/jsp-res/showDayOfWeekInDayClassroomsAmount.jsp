<%--
  Created by IntelliJ IDEA.
  User: NT
  Date: 13.03.2024
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Show Task4</title>
</head>
<body>
<c:forEach var="var" items="${info}">
  <h2>
      ${var.getDayOfWeek()}
  </h2>
  <br><br>
</c:forEach>
</body>
</html>
