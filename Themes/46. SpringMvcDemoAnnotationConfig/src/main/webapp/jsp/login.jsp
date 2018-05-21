
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div class="form-style-6">
    <h1 style="color: ${cookie.color.value}">Login</h1>
    <form action="/login" method="post">
        <input type="text" name="login" placeholder="Login" />
        <input type="text" name="password" placeholder="Password" />
        <input type="submit" value="Login"/>
    </form>
</div>
</body>
</html>

