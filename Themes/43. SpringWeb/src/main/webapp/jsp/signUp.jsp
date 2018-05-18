
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div class="form-style-6">
    <h1 style="color: ${cookie.color.value}">SignUp</h1>
    <form action="/users" method="post">
        <input type="text" name="name" placeholder="Name" />
        <input type="text" name="login" placeholder="Login" />
        <input type="text" name="password" placeholder="Password" />
        <input type="submit" value="SignUp"/>
    </form>
</div>
</body>
</html>
