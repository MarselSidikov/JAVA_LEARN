// filesForm - форма, на которой пользователь
// указал нужные ему файлы
function fileUpload() {
    // форма для отправки на сервер
    var formData = new FormData();
    // получили сами файлы для отправки
    var files = ($('#file'))[0]['files'];

    // необходимо все эти файлы закинут в FormData
    [].forEach.call(files, function (file, i, files) {
        formData.append("file", file);
    });

    $.ajax({
        type: "POST",
        url: "/files",
        data: formData,
        processData: false,
        contentType: false
    }).done(function (response) {
        alert(response)
    })
}

// filesForm - форма, на которой пользователь
// указал нужные ему файлы
function avatarUpload() {
    // форма для отправки на сервер
    var formData = new FormData();
    // получили сами файлы для отправки
    var files = ($('#file'))[0]['files'];

    // необходимо все эти файлы закинут в FormData
    [].forEach.call(files, function (file, i, files) {
        formData.append("file", file);
    });

    $.ajax({
        type: "POST",
        url: "/files",
        data: formData,
        processData: false,
        contentType: false
    }).done(function (response) {
        var inner = "<img src='http://localhost:8080/files/" + response[0] + "'/>";
        alert(inner);
        document.getElementById('avatar').innerHTML =
            "<img src='http://localhost:8080/files/" + response[0] + "'/>"
    })
}