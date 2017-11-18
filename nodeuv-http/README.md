# C++ LibUV based http server

This is a test of the
[nodeuv-http](https://github.com/0x00A/nodeuv-http) server (A simple
http library in c++ backed by libuv and http-parser.)

## Build

```sh
git clone https://github.com/0x00A/nodeuv-http.git
cd nodeuv-http
make
```

## Start

```sh
$ ./server
```

## Bench

```sh
$ wrk -t12 -c400 -d30s http://localhost:8000
```
