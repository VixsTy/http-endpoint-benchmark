# C++ LibUV based http server

This is a test of the
[nodeuv-http](https://github.com/0x00A/nodeuv-http) server (A simple
http library in c++ backed by libuv and http-parser.)

## Build

```sh
git clone https://github.com/0x00A/nodeuv-http.git
cd nodeuv-http
virtualenv2 env
source env/bin/activate
make
```

## Start

```sh
$ ./server
```

## Bench

```sh
$ wrk -t12 -c400 -d30s http://localhost:8000
Running 30s test @ http://localhost:8000
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.83ms   10.75ms 412.66ms   99.34%
    Req/Sec     5.35k     2.09k   14.03k    68.59%
  1908579 requests in 30.09s, 212.96MB read
  Socket errors: connect 0, read 1908538, write 0, timeout 0
Requests/sec:  63431.04
Transfer/sec:      7.08MB
```
