# evpp: A modern C++ network library for developing high performance network services in TCP/UDP/HTTP protocols.


Test of [evpp](https://github.com/Qihoo360/evpp) web framework

## Build

```sh
git clone https://github.com/Qihoo360/evpp.git
cd evpp
git submodule update --init --recursive
sudo apt-get install libevent-dev libgoogle-glog-dev libgflags-dev
mkdir build
cd build
cmake ..
make -j 4
```

# Start

```sh
./bin/bin/example_httpecho
```

## Bench

```sh
$ wrk -t12 -c400 -d30s http://localhost:9009
Running 30s test @ http://localhost:9009
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.14ms  514.70us  51.48ms   94.72%
    Req/Sec     8.01k   523.97    19.48k    86.21%
  2873885 requests in 30.09s, 493.34MB read
Requests/sec:  95509.43
Transfer/sec:     16.40MB
```
