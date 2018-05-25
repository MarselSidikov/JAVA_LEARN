<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div class="names">
    <table>
        <tr>
            <th>
                Привет
            </th>
        </tr>
        <#list names as name>
            <tr>
                <td>
                    ${name}
                </td>
            </tr>
        </#list>
    </table>
</div>
<div class="form-style-6">
    <form action="/users" method="post">
        <input type="text" name="login" placeholder="Login" />
        <input type="text" name="name" placeholder="Name" />
        <input type="submit" value="Сохранить"/>
    </form>
</div>
</body>
</html>