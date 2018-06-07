function getUsers(table) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/users?token=" + getCookie('token'),
        success: function (response) {
            for (var i = 0; i < response.length; i++) {
                table.innerHTML += "<tr>" +
                    "<td>" + response[i]["name"] + "</td>" +
                    "</tr>"
            }
        },
        statusCode: {
            403: function forbidden() {
                alert("Запрещено")
            }

        }
    })
}

function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}