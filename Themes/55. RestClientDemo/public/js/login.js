function login(login, password) {
    var json = {"login" : login, "password" : password};
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/login",
        data: JSON.stringify(json),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            document.cookie = 'token=' + response['value']
        }
    });
}