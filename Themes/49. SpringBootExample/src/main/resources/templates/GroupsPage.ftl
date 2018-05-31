<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Группы</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
</head>
<script>
    function onSelect(groupId) {
        $.ajax({
            url: "http://localhost/groups/" + groupId + "/users",
            success: function (response) {
                var usersCount = response.length;
                var usersList = document.getElementById('users_list');
                usersList.innerHTML = "<ul>";
                for (var index = 0; index < usersCount; index++) {
                    usersList.innerHTML += "<li>" +
                                                response[index]["name"] +
                                            "</li>"
                }
                usersList.innerHTML += "</ul>"
            }
        });
    }
</script>

<body>
<class id="my-select">
    <select size="3" multiple name="groups[]">
        <option disabled>Группы</option>
        <#list groups as group>
        <option id="select_${group.id}"
                onclick="onSelect(document.getElementById('select_' + ${group.id}).value)"
                value=${group.id}>${group.title}</option>
        </#list>
    </select>
</class>
<class id="users_list">

</class>
</body>
</html>