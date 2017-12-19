# C++ Proxygen http server (from Facebook)

This is a test of the
[proxygen](https://github.com/facebook/proxygen.git) Facebook's C++ HTTP Libraries.

## Build

```sh
git clone https://github.com/facebook/proxygen.git
cd proxygen/proxygen
./deps.sh
```

## Start

```sh
cd httpserver/samples/echo/
./echo_server
```

## Bench

```sh
$ wrk -t12 -c400 -d30s http://localhost:11000
Running 30s test @ http://localhost:11000
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     5.41ms    4.40ms  98.71ms   91.23%
    Req/Sec     6.74k     0.95k   18.48k    82.89%
  2418191 requests in 30.10s, 283.23MB read
Requests/sec:  80348.12
Transfer/sec:      9.41MB
```
