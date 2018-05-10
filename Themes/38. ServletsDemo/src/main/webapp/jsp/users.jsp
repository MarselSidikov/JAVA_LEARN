<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users List</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Login</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.login}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
