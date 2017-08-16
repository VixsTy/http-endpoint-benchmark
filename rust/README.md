# Rust Hello World HTTP Server

Using [iron.io](https://github.com/iron/iron) web framework.

## Build

  1. Install RUST via Rustup

```sh
$ curl https://sh.rustup.rs -sSf | sh
```

  2. Build a release binary

```sh
$ cargo build --release
```

## Start

```sh
$ ./target/release/hello-world
```

## Bench

```sh
$ wrk --latency -t12 -c100 -d10s http://localhost:3000/
Running 10s test @ http://localhost:3000/
  12 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   359.75us  688.16us  43.02ms   97.96%
    Req/Sec    24.42k     3.04k   36.05k    71.96%
  Latency Distribution
     50%  274.00us
     75%  401.00us
     90%  565.00us
     99%    1.66ms
  979730 requests in 10.09s, 106.52MB read
Requests/sec:  97093.53
Transfer/sec:     10.56MB
```
