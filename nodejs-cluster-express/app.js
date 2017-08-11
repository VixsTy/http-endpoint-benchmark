var express = require('express');
var app = express();
var cluster = require('cluster');
var numCPUs = require('os').cpus().length;
// var http = require('http');

if (cluster.isMaster) {
  console.log(`Master ${process.pid} is running`);

  // Fork workers.
  for (let i = 0; i < numCPUs; i++) {
    cluster.fork();
  }

  cluster.on('exit', (worker, code, signal) => {
    console.log(`worker ${worker.process.pid} died`);
  });
} else {
  // Workers can share any TCP connection
  // In this case it is an HTTP server
  app.get('/', function (req, res) {
    res.send('Hello World!');
  });

  app.listen(3000, function () {
    console.log('Example app listening on port 3000!');
  });

  // http.createServer((req, res) => {
  //   res.writeHead(200);
  //   res.end('hello world\n');
  // }).listen(3000);

  console.log(`Worker ${process.pid} started`);
}
