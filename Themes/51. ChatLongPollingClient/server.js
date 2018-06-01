
// команда node-js, позволяет получить библиотеку из папки
// node-modules
let express = require('express');

let app = express();
app.use(express.static('public'))
app.listen(8081)
console.log("Server started")