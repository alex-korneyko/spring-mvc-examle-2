<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.09.2016
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<table border="1" style="align-items: center">
    <tr bgcolor="#808080">
        <th>First Name</th>
        <th>Last Name</th>
        <th>Position</th>
        <th>Salary</th>
    </tr>

    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.salary}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
