<%@ page import="ru.itpark.models.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users List</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Height</th>
    </tr>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        for (User user : users) { %>
            <tr>
                <td><%=user.getName()%></td>
                <td><%=user.getAge()%></td>
                <td><%=user.getHeight()%></td>
            </tr>
    <%
        }
    %>
</table>
</body>
</html>
