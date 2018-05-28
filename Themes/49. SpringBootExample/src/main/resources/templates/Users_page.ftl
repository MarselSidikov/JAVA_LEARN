<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script>
        function changeStatus(id, status_element) {
            $.ajax({
                type: "POST",
                url: "/users/" + id + "?action=change_status",
                success: function (response) {
                    status_element.innerHTML = response["state"];
                }
            });
        }
    </script>
</head>
<body>
<div class="names">
    <table>
        <tr>
            <th>
                ID
            </th>
            <th>
                Логин
            </th>
            <th>
                Статус
            </th>
        </tr>
        <#list users as user>
            <tr>
                <td>
                    <p id="user_id">${user.id}</p>
                </td>
                <td>
                    ${user.login}
                </td>
                <td>
                    <p id="state_p" onclick="
                    changeStatus(document.getElementById('user_id').innerHTML, this)">${user.state}</p>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>