const express = require('express');

const app = express();

app.use(express.static('./dist/maganrendelo'));

app.get('/*', (req, res) =>
    res.sendFile('index.html', {root: 'dist/maganrendelo/'}),
);

app.listen(process.env.PORT || 8080);