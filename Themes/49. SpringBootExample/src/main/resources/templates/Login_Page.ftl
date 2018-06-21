<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div class="form-style-6">
    <form action="/login" method="post">
        <input type="text" name="login" placeholder="Login" />
        <input type="password" name="password" placeholder="Password" />
        <label for="rememberMe">Запомнить меня</label>
        <input type="checkbox" name="remember-me" id="rememberMe">
        <input type="submit" value="SignIn"/>
    </form>
</div>
</body>
</html>