const SERVER_API_URL = "http://localhost:8080";

function sendMessage(message, chatId) {
    var json = {};
    json["text"] = message.value;
    $.ajax({
        url: SERVER_API_URL + '/chats/' + chatId + '/messages',
        type: 'post',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(json),
        complete: function () {
            var input = document.getElementById("message");
            input.value = "";
        }
    })
}

function writeMessage(from, message) {
    var select = document.getElementById('chatMessagesList');
    var messageOption = document.createElement('option');
    messageOption.value = 0;
    messageOption.innerHTML = from + " : " + message;
    select.appendChild(messageOption);
}

function getUrlVars() {
    var vars = {};
    window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
        vars[key] = value;
    });
    return vars;
}

function getChats() {
    $.ajax({
        url: SERVER_API_URL + '/chats',
        type: 'get',
        success: function (data) {
            const table = document.getElementById("chats_table");
            for (var i = 0; i < data.length; i++) {
                var row = table.insertRow(i + 1);
                const chatId = data[i]["id"];
                row.onclick = function () {
                    $.ajax({
                        url: SERVER_API_URL + '/chats/' + chatId + '/users',
                        type: 'post'
                    });
                    window.location = "/html/chat.html?id=" + chatId;
                };
                const cellName = row.insertCell(0);
                const cellAuthor = row.insertCell(1);
                cellName.innerHTML = data[i]["title"];
                cellAuthor.innerHTML = data[i]["authorName"];
            }
        }
    })
}

function addChat(chatTitle) {
    var json = {};
    json["title"] = chatTitle;
    $.ajax({
            url: SERVER_API_URL + '/chats',
            type: 'post',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(json),
            complete: function () {
                var input = document.getElementById("chat_name");
                input.value = "";
            }
        }
    )
}

function doConnect() {
    const chatId = getUrlVars()['id'];
    var socket = new SockJS(SERVER_API_URL + '/chat');
    var stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe(
            '/topic/chats/' + chatId,
            // что происходит, когда к нам приходит сообщение
            function (messageOutput) {
                writeMessage(JSON.parse(messageOutput.body).from, JSON.parse(messageOutput.body).message);
            });
    });
}
